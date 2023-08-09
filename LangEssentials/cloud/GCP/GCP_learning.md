## Introduction ##

Google Cloud Platform (GCP) is a public cloud service that
offers some of the same technologies used by Google to deliver
its own products.

=> New Migration verse integration
For example, a
startup could use GCP’s Cloud Identity and Access Management services for all authentication
and authorization needs. A company that has already invested in a Microsoft Active
Directory solution for identity management may want to leverage that system instead of
working solely with the cloud’s identity management system. This can lead to additional
work to integrate the two systems and keep them synchronized.

=> On-prem  data to and from to cloud
Another area of concern for enterprises with their own infrastructure is establishing and
maintaining a secure network between their on-premise resources and their public cloud
resources. If there will be high-volume network traffic between the on-premise systems and
the public cloud, the enterprise may need to invest in dedicated networking between its data
centre and a facility of the public cloud provider. If the volume of traffic does not justify
the cost of a dedicated connection between facilities, then the company may use a virtual
private network that runs over the public Internet. This requires additional network design
and management that a company that is solely in the cloud would not have to address.

```
Compute resources
■■ Storage
■■ Networking
■■ Specialized services such as Machine Learning Services
```

VM - can be created by console and web api
   - Admin rights to it

Load balancer - that provides a single access point to a distributed back end. 
                This is especially useful when you need to have high availability for your application. 
                If one of the VMs in a cluster fails, the workload can be directed to the other VMs in the cluster.

AutoScaler  - Add or remove VM
            - HA and cost saving

managed clusters 
    --  Managed clusters make use of containers.
    --  In a managed cluster, you can specify the number of servers you would
        like to run and the containers that should run on them. You can also specify autoscaling
        parameters to optimize the number of containers running.
    --  the health of containers is monitored for you. If a container fails,
        the cluster management software will detect it and start another container.

cluster management service
    - Monitoring
    - Networking ??
    - Security management tasks ??

Serverless Computing
---------------------
Serverless computing is an approach that allows developers
and application administrators to run their code in a computing environment that does
not require setting up VMs or Kubernetes clusters

GCP has two serverless computing option
    - APP Engine
    - Cloud Function

App Engine - for applications and containers that run for extended periods
of time, such as a website backend, point-of-sale system, or custom business application.

Cloud Function - Cloud Functions is a platform for running code in response to an event, such as
uploading a file or adding a message to a message queue.


Storage
-------
    - Object
    - Block
    - File
    - Cache 
Object store 
    - Meant to Store blob/ Object
    - Not stored as conventional File System but grouped in buckets
    - Can be access by URL
    - Reductancy for HA and durability ( even in different region)
    - ACL Can be applied on each file
    -  it is serverless. There is no need to create VMs and attach storage to them
    - Google Cloud Platform’s object storage, called Cloud Storage, is accessible from servers running in GCP as well as from other devices with Internet access.

File storage
    - hierarchical storage system for files.
    -Google Cloud Platform has a file storage service called
     Cloud Filestore, which is based on the Network File System (NFS) storage system

Where to use FS ? it is suitable for applications that require operating system–like file access to files.
The file system, its directories, and its files exist independent of VMs or applications that may access those
files.

Block
    -ephemeral and persistent disks attached to VMs
    - you can run applications that access blocks directly. Some relational databases can be designed to access blocks directly rather working through file systems. 
In Linux file systems, 4KB is a common block size. Relational databases often write
directly to blocks, but they often use larger sizes, such as 8KB or more

Ephemeral disks exist and store data only as long as a VM is running.
Ephemeral disks store operating system files and other files and data that are deleted when
the VM is shut down. Persistent disks are used when you want data to exist on a block
storage device independent of a VM. These disks are good options when you have data
that you want available independent of the lifecycle of a VM, and support fast operating
system– and file system–level access.

Object Store  -> Independent of life cycle of VM but slow in access (API based access by protocol like HTTP)
Block Store are fast
Object storage can store large volumes of data that are copied to persistent
disk when needed. This combination gives the advantage of large volumes of storage along
with operating system– and file system–based access when needed.

==> “Latency Numbers Every Programmer Should Know” at https://gist.github.com/jboner/2841832 .
```
Reading 1MB of data. If you have the data stored in an in-memory cache, you can retrieve the data in 250 microseconds, 
or 0.25 millisecond If that same data is stored on an SSD, it will take four times as long to retrieve at 1 millisecond.
If you retrieve the same data from a hard disk drive, you can expect to wait 20 milliseconds
```

There are only two hard things in computer science: cache invalidation and naming things

Networking
    - Internal IP - IP of Virtual private cloud
    - External IP - IP exposed to internet. This can be static or ephemeral
        Static addresses are assigned to a
        device for extended periods of time. Ephemeral external IP addresses are attached to VMs
        and released when the VM is stopped.
    -Firewall, Why ? 
        1. control access to subnet or VM in VPC
        Example: A firewall rule can be configured to limit inbound and outbound
        traffic to the IP address of the application server or load balancer in front of the application cluster.
        2. Peering between on-prem DC verse Cloud VPC

Specialized Services
        - Always serverless e.g. text translation, image processing  etc
        - API based access to functionality of the services
        ■ AutoML, a machine learning service
        ■ Cloud Natural Language, a service for analyzing text
        ■ Cloud Vision for analyzing images
        ■ Cloud Inference API, a service for computing correlations over time-series data

-----------------------------------------------
| Cloud  |  On-prem  |  CoLocated Data center |
----------------------------------------------

 DC - This equipment is often owned or leased for extended periods by the company
    - Accurately predict the number of servers - tough job
    - Doesn't work when peak capacity that is significantly higher than the average workload.

 The unit cost of running servers in the cloud may be higher than that of running the
 equivalent server in the data center, but the total cost of on-premise and short-term in the
 cloud mix of servers may still be significantly less than the cost of purchasing or leasing for
 peak capacity and leaving resources idle

Pay-as-You-Go-for-What-You-Use
-  you will typically pay for a minimum period, such as 10 minutes, and then pay per minute used thereafter.
   The unit cost per minute will
   vary depending on the characteristics of the server. Servers with more CPUs and memory
   will cost more than servers with fewer CPUs and less memory

Elastic Resource Allocation
- In the cloud, you could start 20 servers in a matter of minutes. In an on-premise data center, it could take days or
  weeks to do the same thing if additional hardware must be provisioned.
  
