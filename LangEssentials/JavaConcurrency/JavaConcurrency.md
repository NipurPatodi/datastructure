# Locks in JAVA #

1. ##Intrinsic Lock
A synchronized method is a shorthand
for a synchronized block that spans an entire method body, and whose lock is
the object on which the method is being invoked. (Static synchronized methods
use the Class object for the lock.)
```java
synchronized (lock) {
// Access or modify shared state guarded by lock
}
```
Every Java object can implicitly act as a lock for purposes of synchronization;
these built-in locks are called intrinsic locks or monitor locks.

Intrinsic locks in Java act as mutexes (or mutual exclusion locks), which means
that at most one thread may own the lock. When thread A attempts to acquire a
lock held by thread B, A must wait, or block, until B releases it. If B never releases
the lock, A waits forever.

intrinsic locks are reentrant, if a thread tries
to acquire a lock that it already holds, the request succeeds. Reentrancy means
that locks are acquired on a per-thread rather than per-invocation basis

```
When a thread acquires a previously unheld lock, the JVM records the owner and sets the
acquisition count to one. If that same thread acquires the lock again, the count
is incremented, and when the owning thread exits the synchronized block, the
count is decremented. When the count reaches zero, the lock is released.
```
<img src='https://media.giphy.com/media/3o7TKTDn976rzVgky4/giphy.gif' width="150" height="100" /> 

Further, when using locks to coordinate access to a variable, the same lock must be
used wherever that variable is accessed.


### Reordering
In the absence of synchronization,
the Java Memory Model permits the compiler to reorder operations and cache values in registers, and
permits CPUs to reorder operations and cache values in processor-specific caches.

### Stale Data
When the reader thread examines
ready, it may see an out-of-date value. Unless synchronization is used every time
a variable is accessed, it is possible to see a stale value for that variable. Worse, staleness
is not all-or-nothing: a thread can see an up-to-date value of one variable
but a stale value of another variable that was written first

-----

### OUT - OF - THIN - AIR Safetly
<img src='https://media.giphy.com/media/3o7TKTDn976rzVgky4/giphy.gif' width="150" height="100" />

When a thread reads a variable without synchronization, it may see a stale value,
but at least it sees a value that was actually placed there by some thread rather
than some random value. This safety guarantee is called out-of-thin-air safety.
Out-of-thin-air safety applies to all variables, with one exception: 64-bit numeric
variables (double and long) that are not declared volatile (see Section
3.1.4). The Java Memory Model requires fetch and store operations to be atomic,
but for nonvolatile long and double variables, the JVM is permitted to treat a
64-bit read or write as two separate 32-bit operations. If the reads and writes
occur in different threads, it is therefore possible to read a nonvolatile long and
get back the high 32 bits of one value and the low 32 bits of another.3 Thus, even
if you don’t care about stale values, it is not safe to use shared mutable long and
double variables in multithreaded programs unless they are declared volatile
or guarded by a lock.

```java
Locking is not just about mutual exclusion; it is also about memory visibility.
To ensure that all threads see the most up-to-date values of shared
mutable variables, the reading and writing threads must synchronize on
a common lock.
```

### Volatile
The Java language also provides an alternative, weaker form of synchronization,
volatile variables, to ensure that updates to a variable are propagated predictably
to other threads. When a field is declared volatile, the compiler and runtime
are put on notice that this variable is shared and that operations on it should not
be reordered with other memory operations. Volatile variables are not cached in
registers or in caches where they are hidden from other processors, so a read of a
volatile variable always returns the most recent write by any thread.

```java
Use volatile variables only when they simplify implementing and verifying
your synchronization policy; avoid using volatile variables when
veryfing correctness would require subtle reasoning about visibility. Good
uses of volatile variables include ensuring the visibility of their own
state, that of the object they refer to, or indicating that an important lifecycle
event (such as initialization or shutdown) has occurred.
        
        Locking can guarantee both visibility and atomicity; volatile variables can
        only guarantee visibility.
```


You can use volatile variables only when all the following criteria are met:
• Writes to the variable do not depend on its current value, or you can ensure
that only a single thread ever updates the value;
• The variable does not participate in invariants with other state variables;
and
• Locking is not required for any other reason while the variable is being
accessed


### Thread confinement
This technique, thread confinement, is one of the
simplest ways to achieve thread safety. When an object is confined to a thread,
such usage is automatically thread-safe even if the confined object itself is not

Another common application of thread confinement is the use of pooled JDBC
(Java Database Connectivity) Connection objects. The JDBC specification does not
require that Connection objects be thread-safe.9 In typical server applications, a
thread acquires a connection from the pool, uses it for processing a single request,
and returns it. Since most requests, such as servlet requests or EJB (Enterprise
JavaBeans) calls, are processed synchronously by a single thread, and the pool
will not dispense the same connection to another thread until it has been returned,
this pattern of connection management implicitly confines the Connection to that
thread for the duration of the request.

### Immutability
Immutable objects are always thread-safe.
An object is immutable if:
• Its state cannot be modified after construction;
• All its fields are final;12 and
• It is properly constructed (the this reference does not escape during
construction).

`Final fields` can’t be modified (although
the objects they refer to can be modified if they are mutable), but they also
have special semantics under the Java Memory Model. It is the use of final fields
that makes possible the guarantee of `initialization safety` (see Section 3.5.2) that lets
immutable objects be freely accessed and shared without synchronization.

Just as it is a good practice to make all fields private unless they need
greater visibility, it is a good practice to make all fields final
unless they need to be mutable.

