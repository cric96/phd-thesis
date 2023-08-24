# Editor

#Editor Comment 1

> The reviewers recommend acceptance with minor changes; the authors should
> consider the comments when making their final draft. Reviewer 1 in particular
> had detailed suggestions for improvement.

Author response: We are glad the reviewers found merits in our manuscript.
We also thank them for their additional comments, that we have seriously taken
into account for implementing this minor revision.

---

# Reviewer 1

## Reviewer Comment 1.1

> Recommendation: Accept If Certain Minor Revisions Are Made
> Comments: The authors made a good effort to address all the main points raised
> by reviewers in the previous round:
> • the paper now provides a more clear grounding and positioning of the
> contribution to the state-of-the-art
> • the authors did a substantial revision of Section 2 to better delimit the
> conceptual work from the implemented API; this section now includes two
> subsections: “Programming Model” and “From Requirements to an API”
> • the authors revised the code listings with a focus on an example for using
> the API
> • to improve the evaluation, the authors introduced a new “risk level” met-
> ric and added an evaluation focused on spatial tracking; the objective
> is to convey that the system responds as expected to the spatiality and
> evolution of the tracked phenomenon

Author response: We thank the Reviewer for the appreciation of our revisions.


## Reviewer Comment 1.2

> That said, the presentations of both the programming model and implemented
> API are still quite high-level. This makes it hard to determine what is really the
> key takeaway from this paper and how it could be reused. This should be easily
> addressed by further improving the presentation. Some concrete suggestions:
> - Section 1 currently introduces both the requirements and how the proposed
> abstractions are meant to address the requirements; to better delimit the con-
> tribution of the paper, it could help to limit the discussion in Section 1 to
> requirements and move the discussion related to abstractions to Section 2 when
> discussing the programming model
> - what is also missing is a more clear mapping between the proposed abstractions
> and their reflection in the API as shown in Figure 2a: what is currently shown
> in Figure 2a and discussed in the figure’s caption is too disconnected from the
> high-level text in Section 2
> A more clear delineation between Section 1 and Section 2 and a clearer tack
> from the proposed abstractions to the programming model to the API should
> further strengthen Section 2 (the core contribution section).

Author response: The reviewer is right that the presentation of the relation-
ship between requirements and abstractions in Section 1 must be improved. The
presentation was not sufficiently clear about the fact that abstractions derive
from needs, and then we formulate requirements in terms of what the abstrac-
tions should enable. As such, presentation of requirements and presentation
of abstractions cannot be split. We have revised the beginning of subsection
“Requirements and abstractions” to make this point clear, as follows:

    Given the high-level vision and goals discussed in the previous sec-
    tions, and with the help of FloodWatch, we delineate some needs
    together with abstractions and corresponding requirements, for a
    programming model aimed at decentralized situation recognition and
    action.

Then, the reviewer is also right that the mapping between abstractions and
API needs to be correctly draw. Hence, we have clarified and explicitly pointed
out with new sentences in Section 2 the relationship between the elements of
the API and the DD/CCT abstractions. The new sentence is as follows:

    Specifically, class DistributedSensing denotes DDs; types Perception,
    SituatedRecognition, and Action model sensing, reasoning, and
    acting operations, respectively; and decentralisedRecognitionAndResponse
    encapsulates the logic that creates multiple CCTs and manages their
    dynamic partitioning into DDs.

## Reviewer Comment 1.3

> Section 3 (Evaluation) could also benefit from a short introductory paragraph
> that prepares the reader and sets the right expectations for the evaluation.
> This section presents a convincing proof-of-concept for a well-developed and
> realistic scenario. The evaluation is meant to convey to the reader that the
> abstractions, programming model, and API were successfully used to engineer
> a system that responds as expected to the underlying phenomenon. This point
> could be made more explicit to avoid any misunderstanding about performance
> metrics (because the actual performance of the system is not, in fact, evaluated
> and it is not the main point of the evaluation)  

Author response: An introductory sentence has been added at the beginning
of Section 3 as suggested, to clarify the evaluation goals. The new sentence is
as follows:

    In this section, we consider the FloodWatch case study, and show
    that our API can successfully be used in a challenging scenario to
    program a system behavior that responds as expected to the underly-
    ing environmental phenomena.

## Reviewer Comment 1.4

> The above suggestions are only meant to further improve the presentation and
> should be easily addressed.
> Other notes on typos and writing:
> • page 3, L40-41: “information from single sensors provides is too fragile”;
> this phrasing needs to be reviewed
> • page 4, L52-53: “CCTs can be thought as a generalisation of”; can be
> thought of as?
> • page 6, L39: “We exercise the examplar in a more challenging”; the example?

Author response: Thanks for pointing out these typos: they have been fixed.


## Reviewer Comment 1.5

> 1. How relevant is this manuscript to the readers of this periodical? Please
> explain your rating in the Detailed Comments section.: Relevant
> 2. What is the most appropriate forum for the publication of this manuscript?:
> IEEE Magazine (general interest explanatory article with technical contribu-
> tions)
> 1. Please summarize what you view as the key point(s) of the manuscript and
> the importance of the content to the readers of this periodical.: The manuscript
> presents abstractions, a programming model, and API for engineering adaptive
> decentralized systems that can monitor and react to an underlying phenomenon
> (e.g., flooding). The contribution was evaluated by implementing a system for a
> realistic scenario based on open data for rain gauge locations and precipitation
> in the city of Toronto. The topic is highly relevant for the engineering of IoT
> systems.
> 2. Is the manuscript technically sound? Please explain your answer in the
> Detailed Comments section.: Yes
> 3. What do you see as this manuscript’s contribution to the literature in this
> field?: - abstractions and a programming model for adaptive decentralized IoT
> systems; the abstractions build on solid ground and are supported by an API
> that could potentially be reused
> 4. What do you see as the strongest aspect of this manuscript?: - the overall nar-
> rative is well constructed: it goes from requirements and high-level abstractions
> to a proof-of-concept based on real data
> 5. What do you see as the weakest aspect of this manuscript?: - the main
> contribution section could be further consolidated (see concrete suggestions in
> my detailed comments)
> 1. Does the manuscript contain title, abstract, and/or keywords?: Yes
> 2. Are the title, abstract, and keywords appropriate? Please elaborate in the
> Detailed Comments section.: Yes
> 3. Does the manuscript contain sufficient and appropriate references (maxi-
> mum 15)? Please elaborate in the Detailed Comments section.: References are
> sufficient and appropriate
> 4. Does the introduction clearly state a valid thesis? Please explain your answer
> in the Detailed Comments section.: Yes
> 5. How would you rate the organization of the manuscript? Please elaborate in
> the Detailed Comments section.: Satisfactory
> 6. Is the manuscript focused? Please elaborate in the Detailed Comments
> section.: Satisfactory
> 7. Is the length of the manuscript appropriate for the topic? Please elaborate
> in the Detailed Comments section.: Satisfactory
> 8. Please rate and comment on the readability of this manuscript in the Detailed
> Comments section.: Easy to read
> 9. Please rate and comment on the timeliness and long term interest of this
> manuscript to IC readers in the Detailed Comments section. Select all that
> apply.: Topic and content are of immediate and continuing interest to IC readers
> Please rate the manuscript. Explain your choice in the Detailed Comments
> section.: Fair

Author response: We are glad the Reviewer found merits in our manuscript.
The mentioned weakness has been addressed as per the above suggestions.

---

# Reviewer 2

# Reviewer Comment 2.1

> Recommendation: Accept If Certain Minor Revisions Are Made
> Comments: Authors have addressed thoroughly the comments raised in the
> previous round of reviews, and provided an exhaustive response letter.

Author response: We are glad that the Reviewer appreciated our revisions.

# Reviewer Comment 2.2

> There are still a few minor issues which should be addressed, such as a typo in
> line 41 (”provides is”), and a mistake in the caption of Figure 1 (it talks about
> gray boxes, but there are no gray boxes?). If authors correct these few issues,
> this reviewer would recommend acceptance.

Author response: Thanks for pointing out these typos: they have been fixed.


# Reviewer Comment 2.3

> Additional Questions: 1. How relevant is this manuscript to the readers of this
> periodical? Please explain your rating in the Detailed Comments section.: Very
> Relevant
> 2. What is the most appropriate forum for the publication of this manuscript?:
> IEEE Magazine (general interest explanatory article with technical contribu-
> tions)
> 1. Please summarize what you view as the key point(s) of the manuscript and
> the importance of the content to the readers of this periodical.: The paper
> proposes two abstractions to model distributed cyber physical systems, namely
> ”concurrent collective tasks” and ”decentralization domains”. Since the focus
> is distributed systems that monitor and act on a dynamically changing environ-
> ment, the content matches the acope of the IEEE Internet Computing Journal.
> 2. Is the manuscript technically sound? Please explain your answer in the
> Detailed Comments section.: Appears to be - but didn’t check completely
> 3. What do you see as this manuscript’s contribution to the literature in this
> field?: To this reviewer knowledge, there are no similar abstractions in the
> literature, so the contribution seems significant and relevant.
> 4. What do you see as the strongest aspect of this manuscript?: The paper is well
> written and gives clear examples of applications of the abstractions proposed.
> 5. What do you see as the weakest aspect of this manuscript?: The paper lacks
> a more clear formalization of the abstractions. The background on Scala could
> be expanded.
> 1. Does the manuscript contain title, abstract, and/or keywords?: Yes
> 2. Are the title, abstract, and keywords appropriate? Please elaborate in the
> Detailed Comments section.: Yes
> 3. Does the manuscript contain sufficient and appropriate references (maxi-
> mum 15)? Please elaborate in the Detailed Comments section.: References are
> sufficient and appropriate
> 4. Does the introduction clearly state a valid thesis? Please explain your answer
> in the Detailed Comments section.: Yes
> 5. How would you rate the organization of the manuscript? Please elaborate in
> the Detailed Comments section.: Satisfactory
> 6. Is the manuscript focused? Please elaborate in the Detailed Comments
> section.: Satisfactory
> 7. Is the length of the manuscript appropriate for the topic? Please elaborate
> in the Detailed Comments section.: Satisfactory
> 8. Please rate and comment on the readability of this manuscript in the Detailed
> Comments section.: Readable - but requires some effort to understand
> 9. Please rate and comment on the timeliness and long term interest of this
> manuscript to IC readers in the Detailed Comments section. Select all that
> apply.: Topic and content are likely to be of growing interest to IC readers over
> the next 12 months
> Please rate the manuscript. Explain your choice in the Detailed Comments
> section.: Good

Author response: We are glad the Reviewer found merits in our manuscript.
