## Dynamo ##

- Distributed KV store
- Designed on AP of CAP theorem
- Use all concept of cassandra

### Vector Clock ###
The system cannot reconcile the multiple versions of the same object, and the client must perform the reconciliation to \
collapse multiple branches of data evolution back into one (this process is called semantic reconciliation).

### CRDT -> Awesomeness ###
A more straightforward way to handle conflicts is through the use of CRDTs. To make use of CRDTs, we need to model our data in such a way that concurrent changes can be applied to the data in any order and will produce the same end result. This way, the system does not need to worry about any ordering guarantees.\
***Amazon’s shopping cart is an excellent example of CRDT. When a user adds two items (A & B) to the cart, these two operations of adding A & B can be done on any node and with any order, as the end result is the two items are added to the cart***. (Removing from the shopping cart is modeled as a negative add.) The idea that any two nodes that have received the same set of updates will see the same end result is called strong eventual consistency

### Last-write-wins (LWW) ###
Dynamo (and Apache Cassandra) often uses a simple conflict resolution policy: last-write-wins (LWW), based on the wall-clock timestamp. LWW can easily end up losing data. For example, if two conflicting writes happen simultaneously, it is equivalent to flipping a coin on which write to throw away.

***Read Repair because it repairs replicas that have missed a recent update.***


