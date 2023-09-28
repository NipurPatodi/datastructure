## AWS Offerings ##

AWS provide two types of services

1. IaaS: Infra as dervice where AWS will manages Server, network VM for you. They own and operate the data center and give the user VMs and other services at a fractional cost to the user.


2. PaaD: Platform as service on the other hand removes the need for your organization to manage the underlying platforms like a database, streaming services, etc. This allows you to focus on the deployment and management of your core applications and not worry about the IaaS and PaaS layers.


### Infrastructure ###

AWS consist of 4 things
1. Storage ( file/data store like s3 )
2. Compute
3. Database ( why not in storage ?)
4. Network (LB, route 53 , CDS like cloud front)


1. Compute:
	1.1. EC2 (Elastic cloude compute) : this is where create/deploy your own virtual machine. of different compute (RAM + CPU + GPU + OS)
	
	1.2. Elastic container service :  You can think of it as a managed Kubernetes service.
	
	1.3. LightSail: AWS Lightsail launches virtual private servers, which are VMs with individual operating systems but restricted access to physical server resources. Lightsail provides developers compute, storage, and networking capacity and capabilities to deploy and manage websites and web applications in the cloud. Lightsail includes everything you need to launch your project quickly – virtual machines, containers, databases, CDN, load balancers, DNS management etc
	
	1.4 Lambda: Lambda lets you upload a function onto AWS and you pay every time the function is executed or called. You do not need to think about managing the OS or the VM. Lambda does it all for you.\
	
	1.5 Batch:  Batch computing is used for Batch processing. AWS Batch dynamically provisions the optimal quantity and type of compute resources (e.g., CPU vs. memory optimized instances) based on the volume and specific resource requirements of the batch jobs submitted. AWS Batch is a fully managed service that makes it easy to run batch computing workloads on the AWS cloud. It is designed to simplify batch operations, such as those required by scientific simulations, financial modeling, image or video processing, and machine learning workloads.

   1.6 Amazon EMR (Elastic MapReduce) is a fully managed service that makes it easy to process large amounts of data using the popular Apache Hadoop and Apache Spark         
   frameworks. It is designed to simplify big data processing and analysis, such as data warehousing, log analysis, and machine learning.

   Please find good read on batch verse EMR [here](https://boopathy-gopalsamy.medium.com/aws-batch-vs-amazon-emr-use-cases-6f7b374f0504#:~:text=In%20general%2C%20you%20would%20use,use%20of%20Hadoop%20or%20Spark)
   
2. Storage: 
    2.1 **S3**: Amazon Simple Storage Service (Amazon S3) is an object storage service offering industry-leading scalability, data availability, security, and performance.
    
    2.2 **Network Attached Storage (NAS) and Elastic file storage** In the Elastic file System you upload your files to an EFS and then mount that onto multiple virtual machines.
    
    2.3 **Glacier**: it is a storage service used for Data archival. It is primarily used to store data that you do not need to use right away.  It takes 3 – 5 hours to restore from Glacier and it costs $0.01 per gigabyte, per month.
    
    2.4 **Snow Ball**: It is used to transport a large amount of data onto AWS or to take it out of AWS and move it to your data center.
    snow ball is physical device to move data physicall from DS to AWS cloud . This is used for PB of data to avoid data upload over network.
    
    2.5 **Storage Gateway**: It is a VM you install in your data center and this replicates data back into S3. This is used when you have an on-premises data-center and would like to replicate the data onto AWS. Once you have a Storage gateway setup you can replicate to S3 on AWS.
    
 3. Database:

 	3.1: **Relational Database Service (RDS)**: 
 	Amazon RDS gives you access to several familiar database engines, including `Amazon Aurora, MySQL, PostgreSQL, MariaDB, Oracle, and SQL Server`. This means that the code, applications, and tools you already use with your existing databases can be used with RDS.
 	
 	3.2: **Aurora**:It is an AWS proprietary relational Database that is compatible with MySQL and PostgreSQL. 
 	
 	3.3: **DynamoDB**: It is a nonrelational database i.e a NoSQL DB. It is a managed service, i.e you do not need to tune or manage it in any way, AWS does this for you. it falls in CP of cap theorum
 	
 	3.4: **Neptune**: It is a fully managed graph database. Relationships are first-class citizens in graph databases, and most of the value of graph databases is derived from these relationships
 	
 	3.5 **ElasticCache**:  It offers fully managed Redis and Memcached. Seamlessly deploy, operate, and scale popular open source compatible in-memory data stores.
 	
 	
 	3.6. **Amazon Keyspaces (for Apache Cassandra)**: (Serverless cassandra) Amazon Keyspaces (for Apache Cassandra) is a scalable, highly available, and managed Apache Cassandra–compatible database service. With Amazon Keyspaces, you can run your Cassandra workloads on AWS using the same Cassandra application code and developer tools that you use today. 
 	
 	
 	AKS verse hosted cassandra cost study [here](https://medium.com/@hong.cao/cassandra-or-amazon-keyspaces-a6c7d6fd6ca9) 
 	
 	
### AWS Security , Identity and complaince ###

IAM: identity and access management 

Cognition: It is used for device authentication / OAuth service

Guard Duty: Use to monitor malacious activity on  your aws acc

Inspector: Agent installed in your virtual machine and you can run tests for security vulnerabilities etc.

Macie: 
Amazon Macie recognizes sensitive data such as personally identifiable information (PII) or intellectual property and provides you with dashboards and alerts that give visibility into how this data is being accessed or moved. This fully managed service continuously monitors data access activity for anomalies and generates detailed alerts when it detects the risk of unauthorized access or inadvertent data leaks.


certificate service :
It is used to give certificates to any domain you have registered via AWS/Routes 53. This also helps in maintaining and updating certificates that are about to expire.

Cloud HSMHardware Security Module:
It is a dedicated hardware to store your hardware private and public keys, that are used to securely access your application/EC2 instances.

Directory Services:
it is used for integrating your Microsoft active directory services with AWS services.


WAF – Web Application Firewall
WAF sits in front of your web server and it mitigates against injection, cross-scripting. WAF primarily protects your application layer from any malicious attacks


Shield
You get this as a default for your load balancers, cloud front, as well as Route 53. This is basically a DDoS mitigation service that prevents DDoS Attacks.


Artifact
It is a central resource for compliance-related information that matters to you. It provides on-demand access to AWS’ security posture.


### Application integration ###

1. Messaging Queue ( Amazon MQ) : It is a managed message broker service that makes it easy to set up and operate message brokers in the cloud. 
 Message brokers allow software systems, which often use different programming languages on various platforms, to communication and exchange information. Amazon MQ is a managed message broker service for `Apache ActiveMQ and RabbitMQ` that streamlines setup, operation, and management of message brokers on AWS. With a few steps, Amazon MQ can provision your message broker with support for software version upgrades.
 
2. SNS – Simple Notification Service : It provides a low-cost infrastructure for mass message delivery for mobile users.

3. SQS – Simple Queue Service: Amazon-managed queuing service that makes it easy to decouple and scale microservices or distributed systems or serverless applications.


4. SWF – Simple WorkFlow Service: It is used to trigger a workflow. For example, imagine that you have an expense report that needs to be approved by three people. When you submit an experience report the workflow is triggered and the workflow services keep track of each individual who needs to approve your expenses report

```
SQS is a simple queueing service. It doesn't support many higher level abstractions like message routing, fanouts, distribution lists etc. It is a queue - a message is produced, and a message is delivered. It is useful when you need a Queue with limited backing logic.

AWS MQ is a managed Apache ActiveMQ(or RabbitMQ) broker service.

This provides you a fully managed Apache ActiveMQ system in the cloud, with support for a variety of industry-standard queue and broadcast protocols like AMQP, JMS etc. It is useful when you have complicated delivery rules - or when you're migrating an existing system from outside AWS into AWS, and your systems happen to talk to one another with a standard queueing protocol.
```

5. MSK : Amazon Managed Streaming for Apache Kafka (MSK): Securely stream data with a fully managed, highly available Apache Kafka service
 
 	
### Availablity and zoning ###

A `Region` is a geographically distinct area—for example, the west coast of the USA.

`Availability Zones` are datacenters within a region. The availability zones are fault-tolerant between each other. Each Availability Zone (AZ) has its own power and is independent of other AZ within that region.
    

### Media Services ###
Amazon Elastic Transcoder
Kinesis Video Streams
MediaTailor
MediaLive
MediaPackage
MediaConvert
MediaTranscoder

```
Kinesis Comparison. Kafka is more highly configurable compared to Kinesis. With Kafka, it's possible to write data to a single server. On the other hand, Kinesis is designed to write simultaneously to three servers – a constraint that makes Kafka a better performing solution
```

### Machine learning services ###
**SageMaker** is a fully-managed platform that enables developers and data scientists to quickly and easily build, train, and deploy machine learning models.

Polly turns text into lifelike speech, allowing you to create applications that talk, and build entirely new categories of speech-enabled products.

Translate is a neural machine translation service for language translation.

**Comprehend** is a natural language processing (NLP) service that is used to discover insights and relationships in a text.

Rekognition API allows you to automatically identify objects, people, text, scenes, and activities, as well as to detect any inappropriate content.

Transcribe is an automatic speech recognition (ASR) service. You can analyze audio files stored in Amazon S3 and have the service return a text file of the transcribed speech.



**Tensor Flow** helps developers get started with deep learning in the cloud. The framework has broad support in the industry and has become a popular choice for deep learning research and application development, particularly in areas such as computer vision, natural language understanding, and speech translation.

Lex provides the advanced deep learning functionalities of automatic speech recognition (ASR) for converting speech to text, and natural language understanding (NLU) to recognize the intent of the text, to enable you to build applications with highly engaging user experiences and lifelike conversational interactions.

Machine Learning provides visualization tools and wizards that guide you through the process of creating machine learning (ML) models without having to learn complex ML algorithms and technology.




### Analytics services ###

1. **Athena**: is used to run SQL queries in your S3 bucket. Interactive query service that makes it easy to analyze big data that is in S3 using SQL. This is serverless as there is no infrastructure to manage, and you pay only for the queries that you run.

2. **EMR** – Elastic Map Reduce ** is used for processing large amounts of data. This service provides a managed Hadoop Framework that makes it easy, fast and cost-effective to process vast amounts of data across dynamical, scalable EC2 instances.

3. **Quick Sight**: It is a Business intelligence (BI) service that makes it easy to build visualizations, perform ad-hoc analysis, and quickly get business insights from your data. 


4. **Data Pipeline** : is used to move your data across the various AWS services or from your on-premises to AWS. This service also offers various ETL (Extract, transform, load) types of tools.

5. **Glue** is a fully managed extract, transform, and load (ETL) service that makes it easy for customers to prepare and load their data for analytics.


### Management Tools ###

1. Cloud Watch: CloudWatch provides you with data and actionable insights to `monitor your applications`, understand and respond to system-wide performance changes, optimize resource utilization, and get a unified view of operational health.

2. Cloud Formation: Cloud Formation is a way of scripting infrastructure deployments.

3. Cloud Trail : AWS Logging - store data for 1 week
Cloud Trail creates a trail or a log of everything any user does inside of AWS. This stores records of every action carried out by the user for one week.
	
4. Config: Store AWS config with point of time snapshorting

5. Ops works: CHef and puppet way to automate environment

6. Service Catalog: If you work at a large enterprise this service gives you an approved set of images, tools, a database that has been vetted for use within your enterprise

7. Systems Manager:  Patch cloud
8. Trusted Advisor: Recommend on topic like security etc


### Migration service ###
**Database Migration Service**: help to migrate on-premises application to AWS.


**Server Migration Services:** Help to migrate virtual/physical application server to AWS

AR/VR
Sumerian helps in creating and running virtual reality (VR), augmented reality (AR), and 3D applications quickly and easily without requiring any specialized programming or 3D graphics expertise.


And much much more...


## IAM in AWS ##
Identity and Access management syste,

Here are some key points to remember when thinking about IAM:

IAM is universal, it is not specific to a region or AZ

Centralized control to the AWS account
Shared Access to your AWS account

Granular Permissions

Identity federation (like Active Directory)

MFA – Multifactor Authentication – Two factor Auth

Temporary access for users

Allows you to set up your own password rotation policy

Integrates with many different AWS services and supports PCI DSS compliance


In IAM there are four types of entities:

Users – End-users

Groups – A collection of users under one set of permissions.

Roles – You can create roles and then assign them to AWS resources

Policy is a document that defines one or more permissions.

```
Key takeaway: An IAM Policy can be assigned to a User or a Group or a Role.
```

![img.png](img.png)


## EC2 ##

Amazon Elastic cloud compute

AWS EC2 reduces the time required to obtain and boot new server instances to minutes allowing you to quickly scale capacity, both up and down, as your computing requirements change.

###EC2 purchase options###

1. Ondemand:  Fixed rate by the hour or by the second with no commitment.
2. Reserved Instance: You reserve an EC2 instance for your use and this gives you a discount
3. Spot: Enables you to bid whatever price you want to pay for an instance capacity. This is used if your application has a flexible start and stop times.
4. Dedicated Hosts - Can be purchased on-demand, used for regulatory requirements that may not support multi-tenant virtualization.

![img_1.png](img_1.png)


## Elastic Load Balancer (ELB) ##
This is a virtual appliance that is used to distribute traffic across multiple application instances.
Instances are checked by the Load Balancers (LB) and they re-route the traffic if they find an application is not returning any data back.
All AWS Load Balancers have their own DNS name.


### Cloud Watch ##
- Monitoring and setting up alarms that notify the user if an AWS threshold is hit.

- Events in cloud watch help you to respond to a state change of your resources.

### Cloud Trail ##
Audits what is created or modified in terms of AWS infrastructure

### EC2 Placement Groups ##

Logical grouping of instances within a single availability zone. Placement groups are recommended for applications that benefit from low latency and high network throughput or both. example Hadoop cluster or cassandra nodes


## Lambda - Serverless Architecture ##

Lambda is a compute service where you can upload your code and create a Lambda function. AWS Lambda takes care of provisioning and managing the servers that you use to run the code. You do not have to worry about operating systems, patching, scaling etc.

It is essentially described as an event-driven compute service where AWS Lambda runs your code in response to events. These events could be changes to the data in an Amazon S3 bucket or an Amazon Dynamo DB table.

Lambda events can trigger other Lambda events or call other AWS services like SQS or SNS.

**Why Lambda**
1. The Lambda runtime is fully managed by AWS. Once a function is uploaded and configured, Lambda is responsible for managing the resources required to run the code.

2. Developers are free from the traditional overhead of configuring and maintaining server instances.
3. Lambda will immediately scale to meet spikes in demand.
4. Lambda is cost-effective as you only pay for the computational resources used. This is, of course, true for other AWS compute services, but the cost model for 5. Lambda is more granular than EC2 for example, with resources being charged per 100 milliseconds.
5. Lambdas event-driven model means you can integrate nicely with a range of AWS services, but still ensure loose coupling.
6. It’s very low cost. The first 1 million requests are free and you have to pay 0.20 per 1 million requests thereafter!!

```
Limitation of Lambda 
---------------------

* The disk space (ephemeral) is limited to 512 MB.
* The default deployment package size is 50 MB.
* The memory range is from 128 to 3008 MB.
* The maximum execution timeout for a function is 15 minutes*.
* Requests limitations by Lambda:
* Request and response (synchronous calls) body payload size can be up to 6 MB.
* The event request (asynchronous calls) body can be up to 128 KB.

Functional limitation
---------------------
No way to share data between executions

Latency is not guaranteed: The latency of a lambda function execution is not guaranteed because of cold starts.

Not suitable for long-running tasks: There is a hard limit of 15 minutes of execution per call for each lambda

No direct control over CPU powers: You can only define the amount of memory you want to allocate for the Lambda. The maximum amount is 512 megabytes.

```

Please find more details on lambda limitations [here](https://medium.com/geekculture/aws-lambda-limitations-in-real-life-applications-3db7b00b8796)


## Elastic Container Service ##
AWS Elastic Container Service (Amazon ECS) is a highly scalable, fast, container management service that makes it easy to run, stop, and manage Docker containers on a cluster.

### AWS Fargate ###
AWS Fargate is an easy way to deploy your containers on AWS. To put it simply, Fargate is like EC2 but instead of getting a virtual machine you get a container. It’s a compute engine that allows you to use containers as a fundamental compute primitive without having to manage the underlying instances.

Fargate is a serverless, pay-as-you-go compute engine. With Fargate you don't need to manage servers, handle capacity planning, or isolate container workloads for security.

**AWS copilot** CLI to interact with AWS Fargate


```
AWS ECS, EKS, and Fargate are all cloud-based container management services provided by Amazon Web Services (AWS). Here are some key differences between the three:

ECS is a container orchestration service, while EKS is a Kubernetes orchestration service.
ECS provides cluster management capabilities, while EKS provides cluster management capabilities via Kubernetes.
Fargate allows you to focus on your containers without managing the underlying instances, whereas, in ECS and EKS, you have to manage the instances.
ECS and EKS have more flexibility in terms of networking and scaling options compared to Fargate, which only allows for automatic scaling.
EKS is generally more suited for larger and more complex applications, while ECS and Fargate are better suited for simple and smaller applications.
EKS is more expensive than ECS and Fargate since it involves additional costs for running a Kubernetes cluster.
Overall, ECS is the simplest and easiest to use, while EKS and Fargate offer more advanced features and scalability. It ultimately depends on your specific use case and requirements.

```



## S3 - Simple Storage Service ##
Object-Based Storage

secure, durable, highly-scalable object storage. It is easy to use the simple web interface to store and retrieve any amount of data from anywhere on the web.

-> S3 Names must be unique globally

S3 is primarily used for:

- Store and Backup
- Application File Hosting
- Media Hosting
- Software Delivery
- Storing AMI’s and Snapshots

**Consistency** : S3 data consistency model provides strong read after write consistency for PUT and DELETE requests of objects in the S3 bucket.


Objects consist of the following:

Key – this is simply the file name of the object.
Value – the data and is made up of a sequence of bytes.
Versioning – which version of the object is this
MetaData – Additional information about the data file you are storing.
Think, if you are storing a music track/song. This would have metadata like the information of the singer, the year it was released, the name of the album, etc.


Speciality of s3
1. Durable 9.9.. (11 time)
2. Availablity is 99.99%  (could be unavailable 52 minutes and 36 seconds per year)

S3 – IA (Infrequently Accessed) - It is used for data that is accessed less frequently but requires rapid access when needed.

S3 – RRS (Reduced Redundancy Storage) - It provides less durability with the same level of availability.

For example, this is about data you could potentially regenerate like a tax calculation or a payslip. This is cheaper. Suppose you create thumbnails for all your pictures. If you lose a thumbnail you could always regenerate it.

![img_2.png](img_2.png)

**Transfer Acceleration** : Transfer acceleration takes advantage of Amazon cloud front’s (CDN) globally distributed edge locations. As the data arrives at an edge location, the data is routed to Amazon S3 over an optimized network path.


Securing your S3 Buckets
1. By default, all buckets are private
2. You can set up access control for your use
3. Bucket Policies
4. Access control lists (ACL)
5. S3 buckets can be configured to create access logs


## Elastic Block Storage ##

Block store , on which any file system can be mounted . This can attached /dettached with EC2 instance. They are kept in special availablity zone so that it can be repilicated and made available.

Usecases
1. DB
2. OS: Boot /Root of os
3. Mission critical applications/ Entriprice applications
4. Bussiness continuity : By regualar backup using EBS snapshot

Flavor of EBS:
General Purpose SSD (GP2) – price and performance balance

Provisioned IOPS – SSD (IO1) designed for high I/O applications. For example, large relational + NoSQL DB more than 10,000 IOPS

Throughput Optimized HDD (ST1) Magnetic Storage = Old school physical spinning disks. For example, Big Data, & OS processing, data warehousing. Main thing to note is that this cannot be boot volumes.

Cold HDD (SC1) (magnetic Storage) Lowest cost storage for infrequently accessed workloads.

![img_3.png](img_3.png)
Type of store in EC2 :

Amazon Machine Image Storage:
The AWS Machine image store has two types of stores -

- Instance store (Ephemeral Storage)
- EBS Backed Volumes

Instance Store: You will lose data if the underlying host fails.
EBS volume: Root device for an instance launched from AMI. You will not lose data if it is stopped.



## Elastic File System ##

A File system base on NFS4 , where you pay for only what you have used.
it is replicated on multiple availablity zone and this way it make very good candidate for MQ usecase

``` 
Block storage verse Object storage 
-----------------------------------

Object storage However, generally does not provide you with the ability to incrementally edit one part of a file (as block storage does). Objects have to be manipulated as a whole unit, requiring the entire object to be accessed, updated, then re-written in their entirety. That can have performance implications.

- Block storage can be access directly by OS but Obj Storage can only be accessed by rest/ torrent kind of setup
- Block storage compaction and remapping needs to be done  which is not case with S3

Why S3
------
- Data archieving
- static web contains 
- Data backup
- Atleast 3 copy of data
- Resilient

What about the tradeoffs ?
-------------------------

- The primary issues are eventual consistency or strong consistency. Object storage systems are eventually consistent while block storage systems are strongly consistent.

- Strong consistency is needed for real-time systems such as transactional databases that are constantly being written to but provide limited scalability and reduced availability as a result of hardware failures. Scalability becomes even more difficult within a geographically distributed system. Strong consistency is a requirement, whenever a read request must return the most updated version of the data.

S3 wins -> object storage works very well for unstructured data sets where data is generally read but not written to. 

S3->  it does not support the locking and sharing mechanisms needed to maintain a single accurately updated version of a file.


```

S3  can be implemented on-prem using technologies like openstack swift and EMC atmos


## Storage gateway ##

How to connect your on-prim DC to cloud storage?

AWS storage gateway is a service that connects an on-premises software application with cloud-based storage to provide seamless and secure integration between an organization’s on-premise IT infrastructure and the AWS infrastructure.

Storage Gateway is a virtual appliance installed on a hypervisor in your DC. AWS storage gateway’s software appliance is available for download as a VM image that you can install on a host in your data center.

Once you have set up the AWS storage gateway you can use the management console and create the right type of replication.


Types of storage gateway

1. for archieving  Tape Gateway (VTL): Back up and archiving solution allows you to create virtual tapes and send them to S3

2. AWS as read first solution :Volume Gateways (iSCSI)- This is using block-based storage Stored volumes: you would store the entire copy of your site data on AWS Cached volumes: this is where you are only storing the most recently accessed data. i.e. you would use  his if you want AWS as your privacy reading resources

3. File Gateway (NFS): Using NFS, store flat files in S3.

![img_4.png](img_4.png)


## Snowball ##

This is a petabyte-scale data transport solution that uses secure appliances to transfer large amounts of data in and out of AWS.
![img_5.png](img_5.png)


## Databases in AWS ##

Supported DB are 
1. RDS  (Fully managed/ serverless  OLTP )
2. MySql
3. Oracle
4. Postgress
5. Maria DB
6. Aurora (Amazon Aurora is a relational database management system (RDBMS) built for the cloud with full MySQL and PostgreSQL compatibility)
7. Dynamo DB  (C-P / Hbase competitor)
8. Redshift Amazon Data warehouse – OLAP
9. Elastic search
10. ElasticCache - Redis and mamchache

**Type of backup in AWS **

1. Automated backups:  Automated Backups allow you to recover your database to any point in time within a retention period. The retention period can be between 1 – 35 days. Automated backups will take a full daily snapshot and will store transaction logs throughout the day. This allows you to do a point in time recovery down to a second, within the retention period. Automated backups are enabled by default. The backup data is stored in S3 and your tree storage space is equal to the size of the database.

2. Restoring backup
Whenever you restore either an automated backup or manual snapshots, the restored version of the database will be a new RDS instance with a new AWS endpoint.

3. Encryption:
Encryption at rest is supported for MySQL, Oracle PostgreSQL, SQL Server, MariaDB, and Aurora. Encryption is done using the AWS key management Service (KMS) service. Once your RDS instance is encrypted, the data stored at rest in the underlying storage is encrypted as are its automated backups read replies and snapshots.

4. Multiple Availablity Zone:
AWS handles the replication for you. In an event of failure of your database in one availability zone, Amazon RDS will automatically fail to the standby DB can resume without any manual interventions. Multi-AZ is used for disaster recovery only.

5. Read replica
It allows you to have a read-only copy of your production database. This is achieved by using Asynchronous replication from the primary RDS instance to the reach replica. You use read replicas primarily for very read-heavy database workloads.

6. Elastic cache#
You can use ElastiCache for caching, which accelerates application and database performance, or as a primary data store for use cases that don’t require durability.

## RDS ##
![img_6.png](img_6.png)

**How to ensuring high availability of your Database ?**

1. Automatic Failover
2. Synchronous Replication

![img_7.png](img_7.png)

How Multi A-Z failover works:

Each host manages a set of Amazon EBS volumes with a full copy of the data.
Instances are monitored by an external observer to maintain consensus over quorum.
Failover initiated by automation or through the Amazon RDS API.
Redirection to the new primary instance is provided through DNS.

Other approach is Read Replica 

1. Relieve pressure on your source database with additional read capacity
2. Bring data close to your applications in different regions
3. Promote a Read Replica to a master for faster recovery in the event of a disaster
4. Upgrade a Read Replica to a new engine version
5. Supported for MySQL, MariaDB, and PostgreSQL

```
Multi-AZ deployments are not a read scaling solution, you cannot use a standby replica to serve read traffic. The standby is only there for failover.
```
 Read replica verse multiple A-Z more details [here](https://medium.com/awesome-cloud/aws-difference-between-multi-az-and-read-replicas-in-amazon-rds-60fe848ef53a)
 
##Dynamo DB##
 
 No SQL DB with sigle digit milisecond consistency  gauranteed . Support both Documenent and Key value store.
 It is cheap compare to RDS.
 
 Dynamo DB characteristics
Stored on SSD
Spread Across three geographically distinct data centers
Eventual read consistency by default
Strongly consistent reads
Eventual Consistent Reads: Consistency across all copies of data is usually reached within a second. Performing a read after a short duration should return updated data.

Strongly Consistent Reads: A strongly consistent read returns as a result that reflects all writes that received a successful response prior to that read.

##Redsift##

Redshift is a fast powerful and fully managed, Pet-byte-scale data warehouse service in the cloud. It starts small and scale-up and costs a tenth of most other data warehousing solutions. It uses SQL for querying and management.

Massive Parallel Processing (MPP)
Amazon redshift automatically distributes your data and queries across all the nodes.

Columnar Data Storage:  Redsift store data in columner store to optimize aggregates.


## Aurora ##
Aurora will only run on AWS infrastructure. It is a MySQL compatible Relational Database engine that combines the speed and availability of a high-end commercial database with the simplicity and cost-effectiveness of open source databases.

Amazon Aurora provides up to five times better performance than MySQL at a price point one-tenth that of a commercial database while delivering similar performance and availability.

Scaling
Aurora maintains two copies of your data in each availability zone with a minimum of 3 availability zones.

Aurora is designed to transparently handle the loss of up to two copies of data without affecting database write availability and up to three copies without affecting read availability.


InShort Aurora is more optimezed , 100% managed wrapper over DB like Mysql ad Postgres, where as RDS in managed DB Wrapper on DB like , mysql, postgress, aurora , oracle etc.
Please find more detailed comparision [here](https://medium.com/awesome-cloud/aws-difference-between-amazon-aurora-and-amazon-rds-comparison-aws-aurora-vs-aws-rds-databases-60a69dbec41f)

## Neptune ##
Amazon Neptune is a fast, reliable, fully-managed graph database service that makes it easy to build and run applications that work with highly connected datasets. The core of Amazon Neptune is a purpose-built, high-performance graph database engine optimized for storing billions of relationships and querying the graph with milliseconds latency.


Graph DB Usecase
- Social networking: friend and freind of freind feeds etc
- Recommendation engines: make product recommendations to a user based on which products are purchased by others who follow the same sport and have similar purchase histories
- Fraud deduction:  build graph queries to easily detect relationship patterns like multiple people associated with a personal email address, or multiple people sharing the same IP address but residing in different physical addresses.
- Knowledge graphs: 	 if a user is interested in the Mona Lisa, you can also help them discover other works of art by Leonardo da Vinci, or other works of art located in the Louvre. Using a knowledge graph, you can add topical information to product catalogs, build and query complex models of regulatory rules, or model general information.
- Life science
- Network / IT operations 


## DNS ##
Route 53 is a highly available and scalable cloud Domain Name System (DNS) web service. It is designed to give developers and businesses an extremely reliable and cost-effective way to route end users to internet applications by translating
Amazon Route 53 is fully compliant with IPv6 as well.
Type of routing:
Simple Routing
Weighted Routing
Latency Routing
Fail over Routing
Geolocation Based Routing


Weighted Routing: Primarily used for A/B testing. This is where traffic can be split on the different weights assigned.

Latency Routing Policy: This allows you to route your traffic based on the lowest network.

Geolocation Routing Policy: Use when we want to route traffic based on the location of our users.

Geoproximity Based Routing: Used when you want to route traffic based on the location of your resources and optionally shift traffic from resources in one location to resources in another.


## Direct Connect ##

AWS Direct Connect is a cloud service solution that makes it easy to establish a dedicated network connection from your premises to AWS

## CDN (CloudFront) ##

A content delivery network is a system of distributed servers that deliver web pages and other web content to a user based on the geographical location of the user.

Requests for your content are automatically routed to the nearest edge location so that content is delivered with the best possible performance Edge can be used to read or write files objects live on the edge based on the TTL set by the user.


## VPC  ##
Virtual private cloud

A VPC is a logically isolated section of a data center where you have complete control over your virtual networking environment, including the selection of IP address ranges, etc.

Think about it like a virtual data center in the cloud.

Additionally, you can create a hardware Virtual Private Network (VPN) connection between your corporate data center and your VPC and leverage the AWS cloud as an extension of your corporate data center.
 You can connect to a VPC through an internet gateway or a virtual private gateway.
 
 
CIDR
CIDR is a notation for describing blocks of IP address and is used heavily in various networking configurations.


NAT gateways
A NAT gateway is a Network Address Translation (NAT) service. You can use a NAT gateway so that instances in a private subnet can connect to services outside your VPC but external services cannot initiate a connection with those instances.

VPC Flow Logs
VPC Flow Logs is a feature that enables you to capture information about the IP traffic going to and from the network interference with your VPC.
Flow logs data is stored using Amazon cloud Watch logs.


Bastion#
Bastion hosts are instances that sit within your public subnet and are typically accessed using SSH or RDP. Once remote connectivity has been established with the bastion host, it then acts as a ‘jump box’ server, allowing you to use SSH or RDP to log in to other instances (within private subnets) deeper within your VPC.
```
VPN vs. Direct Connect
----------------------

VPN: It can be configured in minutes and is a good solution if you have an immediate need.

You are susceptible to having your data passed via the internet – i.e. low bandwidth, packet drop, etc.

Direct Connect: Does not involve the internet it uses dedicated private network connections between your intranet and Amazon VPC. Following are the advantages and disadvantages of Direct Connect:

Increase Reliability
Higher Bandwidth
Takes longer to set up
```


## Simple Queue service in AWS ##
A producer (component 1) sends message A to a queue, and the message is distributed across the Amazon SQS servers redundantly.

When a consumer (component 2) is ready to process messages, it consumes messages from the queue, and message A is returned. While message A is being processed, it remains in the queue and isn’t returned to subsequent receive requests for the duration of the visibility timeout.

The consumer (component 2) deletes message A from the queue to prevent the message from being received and processed again when the visibility timeout expires.


### SNS – Simple Notification Service ###

SNS – Push notification to mobile devices

Also has SMS text Capability

SNS can trigger email, HTTP, Lamda functions.


### Kinesis ###
Kinesis: Amazon Kinesis is a platform on AWS to send your streaming data too. It is amazons version of Kafka.

Kinesis has three services:

Kinesis Streams
Kinesis Firehose
Kinesis Analytics


Kinesis Firehose - It is the easiest way to reliably load streaming data into data stores and analytics tools. It can capture, transform, and load streaming data into Amazon S3, Amazon Redshift, Amazon Elasticsearch Service, and Splunk, enabling near real-time analytics with existing business intelligence tools and dashboards you’re already using today.


What is SWF?
It is a web service that makes it easy to coordinate work across distributed application components.

Think about an expense report that you submit. It may require a report that you submit. It may require 3 approvals you submit. This would be the job of SWS, you can create a workflow to get approval from manager 1 and then send it for approval to manager 2 and then 3. When the workflow is completed it could even trigger an email notification to you.

SQS is message-oriented and SWS is task-oriented.

SWS – Actors: Workflow Starters – an application that can initiate a workflow. Example: your expense reporting tool. When you hit the “submit” button.

Workflow Decider: Control the flow of activity tasks in a workflow execution. i.e. if a task is finished in a workflow or if it fails the decider, decides what to do next.

Activity Workers carry out the activity tasks.


##General Design principle of AWS##

1. Stop guessing your capacity needs : You can use as much or as little capacity as you need, and scale up and down automatically.

2. Test systems at production scale: In the cloud, you can create a production-scale test environment on-demand, complete your testing, and then decommission the resources

3. Automate to make architectural experimentation easier

4. Allow for evolutionary architectures
 
Five pillars of the well-architected framework#
1.  operational excellence,
2.  security, 
3.  reliability, 
4.  performance efficiency, 
5.  cost optimization
When architecting solutions you make trade-offs between pillars based upon your business context. These business decisions can drive your engineering priorities. You might optimize to reduce cost at the expense of reliability in development environments, or, for mission-critical solutions, you might optimize reliability with increased costs. In e-commerce solutions, performance can affect revenue and customer propensity to buy. `Security and operational` excellence are generally not traded-off against the other pillar

![img_8.png](img_8.png)

### Security design principles ###

Apply security at all layers. E.g. Subnet, ACL’s Ports that are open on the Load Balancer.

Enable tractability. E.g. ability to audit changes using load.

Automate responses to security events E.g. if you detect someone trying to brute force port 22 then it triggers an SNS notification for someone to look at.

Focus on securing your system E.g. you are responsible for securing your data, your application, and your OS.

Automate security best practices.

**Data Protection**
Encrypt data at rest
Encrypt data in motion
Regular key rotation
Detailed logging of changes and access to files
Versioning to protect against accidental overwrite deletes


**Privilege Management**
Ensures that only authorized and authenticated users are able to access the resources. Privilege Management can be done using:

Access Control Lists (ACLs)
Role Based Access Controls
Password Management (password rotation)

### Cost Optimization ###
1. Use managed services to reduce the cost of ownership.
2. Benefit from the economics of scale (loud providers save organizations money because they purchase computing resources in massive quantities at lower costs.)

**Four primary areas**
   Matched supply + demand
   Cost-effective resources
   Expenditure awareness
   Optimizing overtime

### Reliability ###

The reliability pillar covers the ability of a system to recover from service or infrastructure outages/disruptions as well as the ability to dynamically acquire computing resources to meet demand.
E.g. use of chaos monkey to test recovery procedure.
Chaos Monkey is a software tool that was developed by Netflix engineers to test the resiliency and recoverability of their Amazon Web Services (AWS).
Chaos Monkey is responsible for randomly terminating instances in production to ensure that engineers implement their services to be resilient to instance failures.

Design principles
- Test recovery procedures
- Automatically recover from failure
- Scale horizontally to increase aggregate system availability
- Stop estimating/guesting capacity. E.g. No under-provisioning or over-provisioning.

1. Foundation: Start with VPC and identify if you need small- medium or large cloud.
2. Change management -  Use services like Cloud-Watch to monitor your environments and use services like auto-scaling to automate changes.
3. Failure management - In the cloud, you architect systems that are designed to handle failure. In an event when a failure occurs the application owner should be aware of the failures and should have a specific action to respond to failure.
Ideally, you should also have an RCA (Root Cause Analysis) to prevent such failure from happening
- Run Book + RCA


Change management- Cloud Tail+ cloud Watch + autoscaling  group
Failure Management- cloud formation (infra as code)

### Operational Excellence ###
There are three best practice areas for operational excellence in the cloud:
Prepare: Effective preparation is required to drive operational excellence.
Operate: 
Evolve

## AWS Security Fundamental ##

### AWS IAM
Identity and access management 
-it is very important irrespective of your scala 

Cloud in AWS follow `shared responsibility model`. What is it ???
so it mean AWS assure Security of the cloud , it is responsibility of consumer to secure part of cloud we are using

```
Blast radius: It is a measure of the possible consequences in case of a security incident. 
For example, if a web server has access to a database then a hacker can potentially get access to the data, 
so the database is inside the web server’s blast radius.
```

Concept of **least privilage** : To just give enough privilage to user to do his BAU

In AWS API is access gateway to all. Inshort AWS APIs are the gateways to almost everything that happens inside the account. Every resource in AWS is only accessible via the API, which is subject to IAM

`IAM protects AWS APIs only.`

in IAM which is always applied to API call has three people in action<br />
1. The Principal is the entity that is initiating the request.<br />
2. The Action is the operation.<br />
3. The Resource is the target of the operation.

**IAM User**

AWS access methods
1. User can login by console password
2.  user can generate accesskey . this will be used to access all API in aws

Example to run s3 list command
first thing need to be done is 

```
aws configure \ 
  AWS_ACCESS_KEY_ID="AKIAIOSFODNN7EXAMPLE" \
  AWS_SECRET_ACCESS_KEY="nFEMI/RfiCYEXAMPLEKEY" \
  Default region name [us-west-2]: us-west-2 \
  Default output format [json]: json
```

then

`aws s3 ls`

**IAM Roles**

While user credentials are long lived, roles provide a way to use temporary credentials. This provides `better security` as it makes the use of powerful credentials `process-based` instead of `secret-based`.

Example of role used :  - S3 replicating content to another bucket need a role to do so
							- Lambda function need to access another resource , but can only do so if it hase execution role

						
Note that there is also an Expiration element in the response. 
This defines the period that the credentials are valid. 
To maintain access, a user needs to get new credentials periodically.
The advantage of temporary credentials is that if one is exposed to a hacker, it automatically becomes useless in a few hours.


![img_9.png](img_9.png)

IF YOU SEE IN IMAGE  there are two ways 
1> Access by USER credential ( secret key based access)
2> Use Role based temporary credentials  which involve getting it from IAMRole manger service .

How can assume role ?
1. IAM USER
2. AWS Services 
3. Roles 
4. Identities in other AWS services

Anonymous user
1. The anonymous user is when there is no identity in the request, such as when an HTTP request to a website is hosted in a public S3 bucket.
2. AWS services also need to access the account. By default, even the service itself has no access to resources in our account.

----> Need to learn more about role
##Access Element of AWS##

1. **Resouce** : A resource is an AWS entity that serves as the target of an operation. Example is s3
 now when user assumes a role then `resource is the role`
 
 An Amazon Resource Name (ARN) is a global identifier for resources inside AWS. Usually, these are what we need to input when we want to specify an entity.

An ARN is made up of several parts:
`arn:partition:service:region:account-id:resource-id`

The partition is usually aws, the exceptions are regions in China and the US GovCloud.
The service is the AWS product, such as s3 or iam.
The region specifies which region the resource is located if any. There are global resources, such as IAM users, that do not have a region.
The account-id is the 12-digits account number.
And finally, the resource-id is the local identifier of the resource. It can specify sub-resources too, such as the name of objects inside an S3 bucket.

e.g. For example, an sts:AssumeRole operation specifies the role to assume by its ARN: arn:aws:iam::123456789012:role/test-role. This resource is inside the IAM service, which is non-regional, the region is missing, in the 123456789012 account, where it’s a role named test-role.

` An ARN is a global identifier. All resources have a unique value.`

2. **Action**: An action defines what the request does to a resource
3. **Metadata**:  There are other things that are attached to a request made to the AWS APIs. This metadata includes information that conveys the purpose of the request, such as the instance type (ec2:InstanceType) for the ec2:RunInstances action, or the attributes to return (dynamodb:Attributes) for the dynamodb:GetItem. These are part of the request and influence the result.
 
```
The first one is the Principal. It is the user, the role, the AWS service, or some special entity that sends the request.

The second part is the Action. It defines what the Principal wants to do, such as reading an object or creating a new Lambda function.

The third is the Resource. It is the logical entity in the account that is the subject of the request. For example, the specific S3 bucket to delete, or the EC2 instance to launch.


``` 
##CloudTrail##

CloudTrail is a security service that captures what is happening inside the account and across multiple accounts. It stores data about most calls to the AWS APIs and allows browsing their metadata. It’s primarily a security service, designed to help uncover how a breach happened, but it allows some insight into what is in a call that is made to the APIs

CloudTrail stores logs for 90 days, but it’s a best practice to configure it to send them to an S3 bucket for permanent storage. We can configure a trail to do that. But even without any configuration, we can go to the Console and browse the last events.

command line way of doing  it.

```
aws cloudtrail lookup-events
```

op

```
{
    "userIdentity": {
        "type": "IAMUser",
        "userName": "user1",
        // ...
    },
    "eventTime": "2020-11-24T08:10:07Z",
    "eventSource": "s3.amazonaws.com",
    "eventName": "PutBucketTagging",
    "awsRegion": "eu-central-1",
    "sourceIPAddress": "1.2.3.4",
    "userAgent": "...",
    "requestParameters": {
        // ...
    },
    "responseElements": null,
    "resources": [
        // ...
    ],
    // ...
}
```


```
Please note:
CloudWatch is a monitoring service for AWS resources and applications. CloudTrail is a web service that records API activity in your AWS account.
```
 
Cloud tail can also access to what other services are doing ( but please remember .. api part of it)
CloudTrail uses this role, it sends an AssumeRole call to the Security Token Service (STS) API, which in turn appears in the CloudTrail events

Why cloudtrail is not good for debugging ?
1. First, it does not log every event, and it might skip the one that we need
2. it was designed as a forensics tool and not a debugger, meaning its event structure can miss a lot of important information.
3. Although CloudTrail shows what is done, who does it, and on what resource, but most of the metadata is missing. It logs the IP address and the MFA information, but little else.

Complaince 
AWS CloudTrail can help you meet compliance requirements, such as Sarbanes-Oxley (SOX), Payment Card Industry Data Security Standard (PCI DSS), and the Health Insurance Portability and Accountability Act (HIPAA).

**Benefit of CloudTrail**
- Auditing and monitoring activity in your AWS account
- Helping you meet compliance requirements
- Debugging issues in your AWS account
- Tracking changes made to your AWS resources
- Analyzing trends in AWS API usage

Please find more details [here](https://www.linkedin.com/pulse/how-use-aws-cloudtrail-auditing-compliance-debugging-tracking-/)

## Filters## 
When a request reaches an AWS API, the IAM service collects all policies that match the request. It uses the filter elements in the policy to determine following thing.
 
 ` filter is more of match or no match then approved or denied `
 
 1.Principal/NotPrincipal
 
 examples here 
 ```
 // User
 {
    "Principal": {
        "AWS": "<iam>:user/user2"
    },
    // ...
}

// Role
{
    "Principal": {
        "AWS": "<iam>:role/role1"
    },
    // ...
}
//service

{
    "Principal": {
        "service": "lambda.amazonaws.com"
    },
    // ...
}
// anonymous user
 {
    "Principal": {
        "AWS": "*"
    },
    // ...
}
// List of users
{
    "Principal": {
       "AWS": [
            "<iam>:user/user1",
            "<iam>:user/user2"
        ]
    },
    // ...
}
 ```
 
 llly NonPrinciple is negation of this which is more with Deny statements to make an allowlist of users able to access a resource. Example
 
 ```
 {
    "NotPrincipal": {
        "AWS": "<iam>:user/user1"
    },
    // ...
}
 ```
 
 
2. **Resource/NotResource**

LLLy we can specify access to resources

```
// Single resource
{
    "Resource": "arn:aws:s3:::<bucket>",
    // ...
}
// List
{
    "Resource": [
        "arn:aws:s3:::<bucket1>",
        "arn:aws:s3:::<bucket2>"
    ],
    // ...
}
//Wildcard

{
    "Resource": "arn:aws:s3:::<bucket>/*",
    // ...
}
```
 
counter part of resource is NotResource . example

```
{
    "NotResource": "arn:aws:s3:::<bucket>",
    // ...
}

```

3. **Action/NotAction**

this provide restiction on actions

```
// single action
{
    "Action": "s3:GetObject",
    // ...
}
//List
{
    "Action": [
        "s3:GetObject",
        "s3:GetObjectVersion"
    ],
    // ...
}
// Wildcard

{
    "Action": "s3:*",
    // ...
}

// Apart from matching the service, it supports the matching part of the action. This policy matches all actions that start with Get or end with Bucket


{
    "Action": [
        "s3:Get*",
        "s3:*Bucket"
    ],
    // ...
}
// this can be helpfull if we want to restrict any delete/ write to bucket 
```

Note: Using wildcards in the Action element is discouraged. It usually means the policy is broader than it should be. Also, it might match actions that are added in the future. If AWS adds a new one that starts with s3:Get, the above policy automatically applies to that.

Why? because of least privilege principle :D


llly we have notAction

```
{
    "NotAction": "s3:*",
    // ...
}
```

### Condition filter in policy ###
Please note that all we have discussed is going to applied to request and is mapped to IAM policy 

1. With the **String operators**, we can specify what the value needs to be for the policy to match.

```
{
    "Condition": {
        "StringEquals": {
            "s3:ExistingObjectTag/access": "projectA"
        }
    },
    // ...
    
   
}

// Access Tag

{
    "Condition": {
        "StringEquals": {
            "s3:ExistingObjectTag/access": [
                "projectA",
                "projectB"
            ]
        }
    },
    // ...
}

// Wildcard

{
    "Condition": {
        "StringLike": {
            "s3:ExistingObjectTag/access": "project*"
        }
    },
    // ...
}

// Multiple value and all need to pass

{
    "Condition": {
        "StringEquals": {
            "s3:ExistingObjectTag/access": "projectA",
            "aws:PrincipalTag/access": "admin"
        }
    },
    // ...
}

//llly

{
    "Condition": {
        "StringLike": {
            "s3:ExistingObjectTag/access": "project*"
        },
        "StringEquals": {
            "aws:PrincipalTag/access": "admin"
        }
    },
    // ...
}
// Please note that both need to pass

// llly not counter parts
{
    "Condition": {
        "StringNotEquals": {
            "aws:RequestedRegion": [
                "eu-west-1", "eu-central-1"
            ]
        }
    },
    // ...
}

```

2. IfExit conditioning

```
{
    "Condition": {
        "StringEqualsIfExists": {
            "s3:ExistingObjectTag/access": "projectA"
        }
    },
    // ...
}
```
If the access tag is projectA, then the policy matches.
If the access tag is something else, such as projectB, then the policy does not match.
If there is no access tag, then the policy matches.

famous example 
if we want a policy to allow only starting t3.nano EC2 instances, we need to use this statement:

```
{
    "Effect": "Allow",
    "Action": "ec2:RunInstances",
    "Resource": "*",
    "Condition": {
        "StringEqualsIfExists": {
            "ec2:InstanceType": "t3.nano"
        }
    }
}

```
if you see if instance is not defined , it will fallback to t3.nano








3. Variables

Variables in IAM policies are placeholders that get their values from the request metadata.

Example
```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Effect": "Allow",
            "Action": [
                "s3:PutObject"
            ],
            "Resource":
                "arn:aws:s3:::mybucket/${aws:username}/*"
        }
    ]
}
```

The ${aws:username} is the friendly name of the user. This allows Bob to put objects that start with bob/, John to put objects that start with john/, and so on. A single policy provides different permissions to different users.



The ForAllValues: prefix requires all values to be from the defined group. For example, this condition matches only requests where the s3:RequestObjectTagKeys are either access or department:


CIDR ???


![img_10.png](img_10.png)
Link => https://www.youtube.com/watch?v=MmA0-978fSk


## AWS IAM Policy types ##

A policy can be attached to 5 entity in AWS. These are

Identity-based policies: Attached to an IAM user, group, or role
	- role , user , group
Resource-based policies: Attached to AWS resources
	- Resources as S3
Service-control policies: Attached to accounts
   - Account level	 
Session policy: Attached to assume role sessions
	- Role session
Permissions boundary: Attached to identities as a boundary
	???


![img_11.png](img_11.png)


1. **Identity-based policies:** Are directly applied to principle like user, role and group and tell what they can do and what they cannot.

- Inline and managed policies. : When policy is attached to each user , group or role then it is call so.
- Managed policies are separate permission resources that we can attach to multiple identities and manage in a central place. They are often a better way to attach permissions as they provide an easier view of what can be done in the account.

AWS also have Managed policy which user cannot modify but can use them
e.g. AmazonS3ReadOnlyAccess managed policy. hese give only read-only access to a specific service.

2. **Resource-based policies** : Control access to resource



**AWS IAM Policy types**

SCP : Service control policy: If we use the AWS Organizations service to start new accounts we’ll have access to a new type of policy that we can attach to AWS accounts. This allows one account, the management account to impose restrictions on other accounts, the member accounts that are outside their reach. This is a powerful control mechanism because even if a member account is hacked with Administrator access, it is still limited by these outside policies.
 we can do lot
 - restrict access to single region / services / cloud watch etc
 
 ```
 SCPs are powerful tools. As a best practice, create a new account using AWS Organizations immediately after creating your first AWS account and use the member for day-to-day tasks
 ```