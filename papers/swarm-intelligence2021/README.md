# Paper 

## Venue

- [Springer Swarm Intelligence journal](https://www.springer.com/journal/11721)
- [Special Issue on Cross-disciplinary approaches for designing intelligent swarms of drones](https://www.springer.com/journal/11721/updates/19386682)
- **DEADLINE: 22 Dec 2021**

## Ideas

- clustering

## Experiment repository
- https://github.com/cric96/experiment-2021-swarm-intelligence-si

## Related work

- [Dynamically Adaptive Data Clustering Using Intelligent Swarm-like Agents](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.1041.6282&rep=rep1&type=pdf)
- [Swarm intelligence for self-organized clustering](https://www.sciencedirect.com/science/article/pii/S0004370220300047)
    - goal is to cluster high-dimensional data
    - assume _natural clusters_ induced by distances and density-based structures
    - number of clusters is chosen manually from a topographic visualization of the high-dimensional data
    - compared to other (also swarm based) clustering methods does _not_ require neither _overall objective function_ nor _type of clusters_   
- [The Clustered AGgregation (CAG) Technique Leveraging Spatial and Temporal Correlations in Wireless Sensor Networks](https://dl.acm.org/doi/pdf/10.1145/1210669.1210672)
    - Sensed data in Wireless Sensor Networks (WSN) reflect the spatial and temporal correlations of physical attributes existing intrinsically in the environment. In this article, we present the Clustered AGgregation (CAG) algorithm that forms clusters of nodes sensing similar values within a given threshold (spatial correlation), and these clusters remain unchanged as long as the sensor values stay within a threshold over time (temporal correlation). With CAG, only one sensor reading per cluster is transmitted whereas with Tiny AGgregation (TAG) all the nodes in the network transmit the sensor readings. Thus, CAG provides energy efficient and approximate aggregation results with small and often negligible and bounded error 
- [Lightweight Sensing and Communication Protocols for Target Enumeration and Aggregation](https://dl.acm.org/doi/pdf/10.1145/778415.778436)
    - This paper introduces a set of efficient protocols
and algorithms, DAM, EBAM, and EMLAM, for constructing
and maintaining sensor aggregates that collectively monitor target
activity in the environment. A sensor aggregate comprises those
nodes in a network that satisfy a grouping predicate for a
collaborative processing task.
    - The protocol
is developed to support a representative collaborative signal
processing task in sensor networks -- monitoring distinct targets
in a sensor field. Sensors are clustered around each target, or
signal peak, using a 'downhill' protocol. Sensor aggregates
defined by multiple interfering targets are also considered.
- [Energy-Aware Data Collection in Sensor Networks: A Localized Selective Sampling Approach](https://smartech.gatech.edu/bitstream/handle/1853/7710/git-cercs-05-18.pdf)
    - goal is energy savings in collection from sensor network
    - cluster heads are chosen (probabilistically) based on the amount of energy they have
    - cluster assignment based on (1) distance from head (2) similarity of value, clusters can consist of _several connected components_
    - cluster formation is scheduled periodically 
- [Sensing Driven Clustering for Monitoring and Control Applications](https://seapahn.com/papers/CCNC07_clustering.pdf)
    - goal is to partiton sensors for indoor monitoring and control
    - cluster heads are _predetermined_ (based on the _sources_ to be monitored and controlled)
    - cluster assignment is based on the gain _Gij_, an abstraction of the benefit of adding sensor _Si_ to cluster _Cj_
    - cluster formation is scheduled periodically 
    - two thresholds: maximum size for clusters and minimum gain for joining a cluster
- [ASAP: An Adaptive Sampling Approach to Data Collection in Sensor Networks](https://ieeexplore.ieee.org/document/4359398)
- Crowd sensing aware disaster framework design with IoT technologies
    - centralized
    - clustering based on population density in disaster areas
