
When we develop software we expect three basic capablity from it

1. Reliable: Reliability is system’s capability to perform failure-free operation in a given environment for a specified period for a predefined number of input cases, assuming that the hardware and the input are error-free.
2. Resiliency: Resiliency is system’s ability to recover from a fault and maintain persistency of service so that system continues to work despite failures.
3. scalable:Scalability is system’s potential to increase capacity and functionalities based on its users’ demand.


## Reliable Best Practice:
1. Architect for redundancy to avoid single point of failure (SPOF)
2. Setup metrics on service usage trends
3. Throttle abnormal high volume & high latency callers ( Rate limiting)
4. Periodically perform **logging hygiene** as bad logging can fill up your disks and cause a system to do even more work when it’s degrading
5. Ensure not all regions are deployed at one time
6. Automate deployments, verifications and rollbacks to achieve consistency



## Resiliency Best Practices
1. Recognize the most critical API and reserve capacity for it to keep service afloat even if a portion of it is failing
2. Prevent retry storms by aggregating retries at process, host or service level
3. Set timeouts of dependency calls such that together each call is lower than overall Latency SLA of the service
4. Have lever-based mechanisms that allows to turn off functionality and limit load to dependencies during outages to limit the spread of failures
5. Routinely test for/with failure: Chaos, Stress, Soak Tests

**Chaos Test**: Testing system by continuously, however randomly injecting failures from dependencies
**Stress Test**: Testing system beyond normal operating points and evaluate system limits for extreme conditions
**Soak Test**: Testing system under a huge volume of load for long duration to find performance issues and resource leaks like memory, thread pools etc.

##Scaling Best Practices
1. Bias towards microservice design strategy where each service performs one business function so that it is easy to cut or replace to better handle failure
2. Consider to use serverless or container based infrastructure for small services to reduce effort for planning scaling for them
3. Configure early alerts for each service in case of abnormal breaching so that it buys time for fix
 4.  Automate operational scaling with Scaling Planners like CloudTune for EC2 in AWS
 5.   Have automated alarms and dashboards for resource utilization and performance metrics like SLA on Availability, Latency, Error, Fault etc.
 6.   Automate the running of load tests with every deployment release