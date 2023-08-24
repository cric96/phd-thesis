# Tracking Spatio-Temporal Phenomena
## Combine Aggregate Computing with Spatio-Temporal Neural Network
### Code repository

| Data generation | Alchemist Simulation
|-|-|
| [Link](https://github.com/cric96/scala-boids) | [Link](https://github.com/cric96/alchemist-boids) |

### Brainstoarming
In this document, I will discuss the idea behind the work that I started here in Aarhus.
The general idea is summarised in this figure:
![idea-1](https://user-images.githubusercontent.com/23448811/192802282-2662a2b2-5821-4c14-b918-bdeda065c83c.png)

In this work, we consider *Cyber-Physical Swarms* as a system of reference: they are systems composed of thousands/hundreds of entities that expose **collective** and **resilient** behaviours while achieving collective goals. In these systems, we typically don't have a central authority that coordinates the agents, and moreover, the agents have only a limited view of the system (local sensing and messages through the neighbourhood).

Particularly, here we wanna explore a *distributed* *collective* tracking approach: the nodes should follow spatiotemporal phenomena over time (e.g., fire in a forest, school of fish, moving people), in a way in which the nodes can cover the phenomenon of interest. 
Moreover, the nodes should cover the space since they can control the whole selected region somehow.
The tracking concerns either the movement (i.e., the nodes should physically follow the changing data) and the data acquisition (i.e., the nodes should have a clear vision of the tracked sensing). 
The latter is relevant to understand the distribution and making action using that information (i.e., in case of fire, the system should understand the centre and the border of it).

In this paper we would follow the following approach:
- for tracking the spatiotemporal phenomenon, we would leverage a Neural Network that forecasts the next value of the perceived data
- using aggregate computing, we would like to control the system, e.g., by producing a movement field that moves the system toward the forecast information 

This integration could be useful for future work too, particularly, understanding how to use NN in an Aggregate Computing scenario could help us to improve the current solution in which we combine RL and AC (e.g., for power reduction, ...).


### Neural Network

![idea-2](https://user-images.githubusercontent.com/23448811/192802346-6fdc57c9-0d4e-43fc-81d2-2a4441358168.png)

In this case, there are several possibilities regarding neural network models that we can use.
Regarding the temporal aspect, the so-called recurrent networks have been used for years already.
These, have the benefit of encoding past information through memory. 
By doing so, it is easier to understand temporal evolution and make more robust forecasts.
In this case, then, neural networks such as GRU or LSTM could be used as a way to make accurate predictions of future values.
The problem with these approaches is that they do not consider the spatial aspect. 
Thus, we have two possibilities:
- we consider only the local output: in the case of simple phenomenon, local information might be enough to have an acceptable result in terms of prediction
- we perform hadmand feature extraction, but it is not always trivial to figure out how to extract information from a variable neighborhood

Therefore, an alternative to these neural networks might be graph neural networks (GNN). These allow us to consider neighborhood data and work on variable inputs. 
GNNs (e.g., GCNs) can also be used through pointwise (local only) evaluation (maintaining synchrony, otherwise this property is lost).
Unfortunately, regular GNNs do not encode the temporal aspect. 
We could either collect a set of data (i.e., time windows) and then try to make forecasts using this information or we could use only the spatial information and see how much this can help in predictions of future values.

Finally, in the last year, spatiotemporal neural networks  (STNN) have been proposed (e.g., T-GCN).  
The general idea consists in stacking a layer of GNN with a layer of RNN.
The problem with STNN is that some implementations couldn't be split in local-wise evaluations, since they consider both spatial and temporal information. 

### Training Schema
As in the previous work, we decided to adopt a Centralised Training and Decetrnalsed Execution approach, but this time we employ a supervised learning structure.
First of all, we extract the phenomenon data from the simulation of node displaced in a random grid. 
Conceptually, the dataset is a sequence of snapshots of a graph -- more details with be discussed in the next section.
Using this global information, we train a model (GNN, RNN, STNN) that will work also in case of only local knowledge (therefore in the case of GNN we can use only 1-hop neighborhood at most otherwise it cannot be used in aggregate computing). Lastly, we deploy the model in each node of the system and they will use it to make local predictions about the evolution of the phenomena of interest.

This approach has the issue of needing simulation data and a global training step. But then, you can use this model at runtime without using a global coordinator -- that is our main interest.
Another possible problem related to GNN is that they consider a synch update of the whole structure. I need more experiments to verify the influence of the async distributed evaluation.

Another possible issue is related to time. LSTM is made for sequential data, so if the time between perception changes, by the LSTM there are no changes. Therefore we need to understand if this could be problematic.

![idea-3](https://user-images.githubusercontent.com/23448811/192802423-36cbb91e-5f6e-4623-8505-f6a7d99de766.png)

### Training Data
We consider the Aggregate System as a Dynamic Graph.
$$G_t=(X_t, \Delta_t)$$
Consider a fixed time step $T=t$, then each node has a feature $x_i \in X$ that is related to the perception at the time $t$. 
$x_i$ could be a multi-dimensional feature, so $x_i \in \mathbb{R}^n$. 
Each node could have neighbours, the link between two nodes is defined as $\delta_{ij} \in \Delta$. In this case, we consider an undirected graph, so $\delta_{ij} = \delta_{ji}$.
$\delta_{ij}$ could capture edge features. In this case (Aggregate Systems) we could have a distance (computed by a given metric) or a distance vector.
![idea-4](https://user-images.githubusercontent.com/23448811/192802500-ad29cd52-8934-4c11-ba38-a495935125ef.png)

### Aggregate Computing & Neural Networks
Inside an aggregate program, we could use each of the neural networks proposed.
The simplest one is RNN.
In the case of RNN, we can conceptually only use `rep`:
```scala
rep(sense("phenomenon")) {
  data => RNN(data)
}
```
In the case of GNN instead, we need to collect both the node feature and the edge features.
We can do this using nbr + foldhood:
```scala
val edges = foldhoodPlus(List.empty)(_ ::: _)(nbr(edge)) //e.g., nbrRange
val features = foldhood(List.empty)(_ ::: _)(nbr(sense("perception")))
GNN(features, edge)
```
Finally, if we wanna combine both, we need to leverage both the memory and the spatial aspects. For this reason we need to use rep and nbr + foldhood: 


![idea-5](https://user-images.githubusercontent.com/23448811/192802570-48968263-1bbb-42e2-889b-62ecd5d1991a.png)

### Tracking Schema
Once we have built a neural network model capable of looking into the future, 
 we use this information in AC to calculate the movement verse of the nodes.
The idea is to use the information computed by the neighbors 
 to compute the partial derivatives in time and space. 
Using this information, we build the velocity vector. 
If everyone followed the phenomenon however, 
 the space may not be adequately covered. 
For this reason, we think of adding the following constraint: 
 If the phenomenon is well covered (i.e., there are enough nodes) 
 then the nodes should avoid following the phenomenon and return to their initial position. 
 This might have telemetry problems in reality, but we assume that the nodes somehow manage to return to their current position

![photo_2022-09-29_15-26-38](https://user-images.githubusercontent.com/23448811/193045242-34a54496-17e6-4bd9-a79a-ebaf0b51e53a.jpg)

### Todos
- [x] simulation tracking the spatial data
- [x] create the dataset
- [x] predict the next time step
- [x] integrate PyTorch in Alchemist
- [ ] direction field using forecast (? problem with the gradient evaluation)
- [ ] check the influence of the neighborhood size (? try to export feature instead of only the weight for the neural network) 
- [ ] check the influence of memory (? partially tried) 
- [ ] use time window instead of single value
### Library used
- [ScalaPy](https://scalapy.dev/): to make possible the interaction between Scala and Python
[Pytorch](https://pytorch.org/): the main framework for training the neural network
- [Pytorch Geometric](https://pytorch-geometric.readthedocs.io/en/latest/): library used for managing the spatial data (graphs)
- [Pytorch Geometric Temporal](https://pytorch-geometric-temporal.readthedocs.io/en/latest/): library used for the temporal extension of PyTorch geometric (kind of unstable currently, and with an unclean API)
