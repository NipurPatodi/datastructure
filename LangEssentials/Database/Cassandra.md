## Cassandra ##
Apache Cassandra was initially designed at Facebook using a staged event-driven architecture (SEDA) to implement a combination of Amazon’s Dynamo distributed storage and replication techniques and Google’s Bigtable data and storage engine model.

**Keyspace**: Defines how a dataset is replicated, per datacenter. Replication is the number of copies saved per cluster. Keyspaces contain tables.

**Table**: Defines the typed schema for a collection of partitions. Tables contain partitions, which contain rows, which contain columns. Cassandra tables can flexibly add new columns to tables with zero downtime.
table -> Partition->row->columns
**Partition**: Defines the `mandatory part of the primary key` all rows in Cassandra must have to identify the node in a cluster where the row is stored. All performant queries supply the partition key in the query.

**Row**: Contains a collection of columns identified by a `unique primary key` made up of the `partition key `and optionally additional `clustering keys`.

**Column**: A single datum with a type which belongs to a row.

# What cassandra use ?
1. Data storage : Log Structured Merge Tree (LSM).
2. partitioning : Using consistent hashing
3. Distributed cluster membership and failure detection : Gossip protocol

Cassandra uses a `Last-Write-Wins` Element-Set conflict-free replicated data type

Consistent hashing (Read form SDI book)

#### Multi-master Replication: Versioned Data and Tunable Consistency

NetworkTopologyStrategy requires a specified replication factor for each datacenter in the cluster

Cassandra uses mutation timestamp versioning to guarantee eventual consistency of data. Specifically all mutations that enter the system do so with a timestamp provided either from a client clock or, absent a client provided timestamp, from the coordinator node’s clock. Updates resolve according to the conflict resolution rule of last write wins. Cassandra’s correctness does depend on these clocks, so make sure a proper time synchronization process is running such as NTP.

#### Replica Synchronization:
cassandra has many best-effort techniques to drive convergence of replicas including Replica read repair <read-repair> in the read path and Hinted handoff <hints> in the write path

These techniques are only best-effort, however, and to guarantee eventual consistency Cassandra implements anti-entropy repair <repair> where replicas calculate hierarchical hash-trees over their datasets called Merkle trees that can then be compared across replicas to identify mismatched data. .


Cassandra supports a per-operation tradeoff between consistency and availability through Consistency Levels. Cassandra’s consistency levels are a version of Dynamo’s R + W > N consistency mechanism where operators could configure the number of nodes that must participate in reads (R) and writes (W) to be larger than the replication factor (N).

The following consistency levels are available:

ONE
Only a single replica must respond.

TWO
Two replicas must respond.

THREE
Three replicas must respond.

QUORUM
A majority (n/2 + 1) of the replicas must respond.

ALL
All of the replicas must respond.

LOCAL_QUORUM
A majority of the replicas in the local datacenter (whichever datacenter the coordinator is in) must respond.

EACH_QUORUM
A majority of the replicas in each datacenter must respond.

LOCAL_ONE
Only a single replica must respond. In a multi-datacenter cluster, this also gaurantees that read requests are not sent to replicas in a remote datacenter.

ANY
A single replica may respond, or the coordinator may store a hint. If a hint is stored, the coordinator will later attempt to replay the hint and deliver the mutation to the replicas. This consistency level is only accepted for write operations.

Write operations `are always sent to all replicas`, regardless of consistency level. The consistency level simply controls how many responses the coordinator waits for before responding to the client.

#### Gossip
Gossip is how Cassandra propagates basic cluster bootstrapping information such as endpoint membership and internode network protocol versions.
Every node in Cassandra runs a variant of the Phi Accrual Failure Detector, in which every node is constantly making an independent decision of if their peer nodes are available or not. This decision is primarily based on received heartbeat state. For example, if a node does not see an increasing heartbeat from a node for a certain amount of time, the failure detector "convicts" that node, at which point Cassandra will stop routing reads to it (writes will typically be written to hints). If/when the node starts heartbeating again, Cassandra will try to reach out and connect, and if it can open communication channels it will mark that node as available.


---- Data Storage ----

CommitLog:
----------

Commitlogs are an append only log of all mutations local to a Cassandra node. Any data written to Cassandra will first be written to a commit log before being written to a memtable. This provides durability in the case of unexpected shutdown. On startup, any mutations in the commit log will be applied to memtables.

All mutations write optimized by storing in `commitlog segments`, reducing the number of seeks needed to write to disk.
Commitlog segments are truncated when Cassandra has written data older than a certain point to the SSTables. 

commitlog_sync: may be either periodic or batch.

batch: In batch mode, Cassandra won’t ack writes until the commit log has been fsynced to disk. It will wait "commitlog_sync_batch_window_in_ms" milliseconds between fsyncs. This window should be kept short because the writer threads will be unable to do extra work while waiting. You may need to increase concurrent_writes for the same reason.

commitlog_sync_batch_window_in_ms: Time to wait between "batch" fsyncs Default Value: 2

periodic: In periodic mode, writes are immediately ack’ed, and the CommitLog is simply synced every "commitlog_sync_period" milliseconds.

commitlog_sync_period: Time to wait between "periodic" fsyncs Default Value: 10000ms

Memtables
----------
Memtables are in-memory structures where Cassandra buffers writes. In general, there is one active memtable per table. Eventually, memtables are flushed onto disk and become immutable SSTables. This can be triggered in several ways:

The memory usage of the memtables exceeds the configured threshold (see memtable_cleanup_threshold)

The commit-log approaches its maximum size, and forces memtable flushes in order to allow commitlog segments to be freed

Memtables may be stored entirely on-heap or partially off-heap, depending on memtable_allocation_type.


SSTables
----------
SSTables are the immutable data files that Cassandra uses for persisting data on disk.

As SSTables are flushed to disk from memtables or are streamed from other nodes, Cassandra triggers compactions which combine multiple SSTables into one. Once the new SSTable has been written, the old SSTables can be removed.

Gaurantee
----------

Cassandra makes the following guarantees.

High Scalability

High Availability

Durability

Eventual Consistency of writes to a single table

Lightweight transactions with linearizable consistency

Batched writes across multiple tables are guaranteed to succeed completely or not at all

Secondary indexes are guaranteed to be consistent with their local replicas data



### Data Modeling  in cassandra ###
------------------------------------
Query-driven modeling :
Since each query is backed by a table, data is duplicated across multiple tables in a process known as denormalization