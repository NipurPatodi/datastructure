# Micro Services #
- Domain-driven design. 
  Continuous delivery. 
  On-demand virtualization. 
  Infrastructure automation. 
  Small autonomous teams. 
  Systems at scale. 
  
Microservices have emerged from this world.
###1. Small
Microservices are small, autonomous services that work together. 

    This is reinforced by Robert C. Martin’s definition of the Single
    Responsibility Principle, which states “Gather together those things that change for the
    same reason, and separate those things that change for different reasons.”

But how much small is small
    - a microservice as something that could be rewritten in two weeks, a rule of thumb that makes sense for his particular context.
###2. Autonomous

Autonomous. These services need to be able to change independently of each other, and be deployed by themselves without requiring consumers to change.
        The golden rule: can you make a change to a service and deploy it by itself without changing anything else?

service-oriented architecture ??? What is it ???

### Key Benefit
1. Technology Heterogeneity :This allows us to pick the right tool for each job,
   rather than having to select a more standardized, one-size-fits-all approach that often
   ends up being the lowest common denominator.  ( Write each MS in right technology)
   
2. Resilience: If one component of a system fails, but that failure doesn’t cascade, you can isolate the problem and the rest of the
   system can carry on working. Service boundaries become your obvious bulkheads. but with
   microservices, we can build systems that handle the total failure of services and
   degrade functionality accordingly. ( Key word is service bounderies and fail cascading is handled)
   
3. Scaling: With smaller services, we can just scale those services that need scaling, allowing us
   to run other parts of the system on smaller, less powerful hardware
   
4. Ease of Deployment:  With microservices, we can make a change to a single service and deploy it independ‐
   ently of the rest of the system. This allows us to get our code deployed faster. If a
   problem does occur, it can be isolated quickly to an individual service, making fast
   rollback easy to achieve. It also means we can get our new functionality out to customers faster.
   
5. Organizational Alignment: Microservices allow us to better align our architecture to our organization, helping us
   minimize the number of people working on any one codebase to hit the sweet spot of
   team size and productivity.
   
6. Composability: Should be open to be consumed by multiple sources. With microservices, think of us opening up seams in our system that are addressable
   by outside parties.
   
7. Optimizing for Replaceability:  Teams using microservice approaches are comfortable with completely rewriting
   services when required, and just killing a service when it is no longer needed. When a
   codebase is just a few hundred lines long, it is difficult for people to become emotion‐
   ally attached to it, and the cost of replacing it is pretty small.
   - use it and throw it. 
     
Service-oriented architecture
-------------------------------     
Service-oriented architecture (SOA) is a design approach where multiple services col‐
laborate to provide some end set of capabilities. A service here typically means a com‐
pletely separate operating system process. Communication between these services
occurs via calls across a network rather than method calls within a process boundary.


The Open Source Gateway Initiative (OSGI) is worth calling out as one technology specific approach to modular decomposition.

Before we finish, I should call out that microservices are no free lunch or silver bullet.
d. If
you’re coming from a monolithic system point of view, you’ll have to get much better
at handling deployment, testing, and monitoring to unlock the benefits we’ve covered
so far. You’ll also need to think differently about how you scale your systems and
ensure that they are resilient. Don’t also be surprised if things like distributed transac‐
tions or CAP theorem start giving you headaches, either

