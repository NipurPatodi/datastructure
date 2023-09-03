## CAP ##
According to the initial statement of the CAP theorem, it is impossible for a distributed data store to provide more than two of the following properties simultaneously: consistency, availability, and partition tolerance.
Consistent: All read get value of latest write

Available: Availability means that every request receives a non-error response, without any guarantees on whether it reflects the most recent write request.

Partition Tolerance:
Partition tolerance means that the system can continue to operate despite an arbitrary number of messages being dropped by the network between nodes due to a network partition.

When we read the literature and documentation of distributed systems, we notice that systems are usually classified into two basic categories: CP and AP. This classification depends on which property the system violates during a network partition.


When no network partition is present during normal operation, there’s a different trade-off between latency and consistency.

To guarantee data consistency, the system will have to delay write operations until the data has been propagated across the system successfully, thus taking a latency hit.
```
An example of this trade-off is the single-master replication scheme. In this setting, the synchronous replication approach would favor consistency over latency. Meanwhile, asynchronous replication would reduce latency at the cost of consistency.
```

##PACELC##
The PACELC theorem is an extension of the CAP theorem

```
In the case of a network partition (P), the system has to choose between availability (A) and consistency (C) but else (E), when the system operates normally in the absence of network partitions, the system has to choose between 
latency (L) and consistency (C).
```


Each branch of the PACELC theorem creates two sub-categories of systems.

The first part of the theorem defines the two categories we have already seen: CP and AP.

The second part defines two new categories: EL and EC.

These sub-categories are combined to form the following four categories:

AP/EL Available partitioned/elastic latency
CP/EL
AP/EC
CP/EC

----------


Cassandra-> PA  and EL ( Consistency is tunebale)
Riak -> PA and EL (Dynmo inspired design)
Dynamo -> PA and EL
Cosmo DB -> PA and EL

HBase -> PC and EC ( Big Table design)
VoltDB ->PC and EC

RDBMS Cluster ( Shared My SQL) -> PC and EC

DYNAMO DB (KV Store)->  although has read after write but this is not applicable to global table
                    -> EL by default to support low latency read but can be tuned for consistency

Couchbase -> HIghly tuneable
Cosmos DB  -> CP  but  C/A during P, and L/C during E.

MongoDB -> PC EC ( GAURENTEE READ WRITE TO BE CONSISTENT)

Hazelcast IMDG (in memory data grid)-> PA/EC but EL can be configured
