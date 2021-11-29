## Twitter Prep strategy ## 
### Evaluted on ###
1. Requirement gathering
   - prompting 
   - Ask clear Question on design and assumptions
   
2. Event Instrumentation
   - Event structure
   - FLow 
   - data model  about of capture data
   - Kind of analysis Data Model will enable
     
   
3. Analytical and data pipeline design
- Discuss alert
- monitoring 
- SLA of data pipelines
- Enriching info with other data set

4. Matrix computation
- Storing different matrix
- Discuss different dimension for creating user level or aggregated matrix
- Pros and cons of user level matrix
- cohort analysis

5. Experimentation Design
- little to no hands  talk about ev testing
- matrix
- features switch
- system like  DBG
- comparing variance using matrix  to access the performance.

    product manager- product releated matrix
  away team model
  

### APM ( Application Performance Monitoring) Matrix ###
1. The application performance index (Apdex) :
   It works by specifying a goal for how long a specific web request or transaction should take.
   Those transactions are then bucketed into satisfied (fast),\
   tolerating (sluggish), too slow, and failed requests. \
   A simple math formula is then applied to provide a score from 0 to 1
![img.png](img.png)
   
2. Average Response Time
3. Error Rates
   - HTTP Error % – Number of web requests that ended in an error
   - Logged Exceptions – Number of unhandled and logged errors from your application
   - Thrown Exceptions – Number of all exceptions that have been thrown
4. Count of Application Instances\
   If your application scales up and down in the cloud, it is important to know how many server/application instances you have running.\
   if your application automatically scales up based on CPU usage, you may never see your CPU get high. You would instead see the number \
   of server instances get high. (Not to mention your hosting bill going way up!)
   
5. Request Rate:\
   how much traffic your application receives\
   Monitoring the request rate can also be good to watch for spikes or even inactivity. If you have a busy API that suddenly gets no traffic at all, that could be a really bad thing to watch out for.
   
6. Application & Server CPU

7.  Application Availability\
    Monitoring and measuring if your application is online and available is a key metric you should be tracking. Most companies use this as a way to measure uptime for service level agreements (SLA).

8. Garabage collection \
   Garbage collection metrics may not be one of the first things you think about key application performance metrics. It can be a hidden performance problem that is always a good idea to keep an eye on
   
Please find more details @ https://stackify.com/application-performance-metrics/

## Data protection at transit and at rest ##

You can mount a file system so that all NFS traffic is encrypted in transit using Transport Layer Security 1.2 (TLS) with an industry-standard AES-256 cipher. TLS is a set of industry-standard cryptographic protocols used for encrypting information that is exchanged over the network.