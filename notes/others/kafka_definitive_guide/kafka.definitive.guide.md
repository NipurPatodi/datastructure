## Definition
Apache Kafka was developed as a publish/subscribe messaging system.It is often described as a “distributed commit log” or more

## Why Kafka

Five Reasons:

1. Multiple Producers:able to seamlessly handle multiple producers

2. Multi consumer: Kafka is designed for multiple consumers to read

3. Disk-Based Retention:

Not only can Kafka handle multiple consumers, but durable message retention means

4. Scalable:
Kafka’s flexible scalability makes it easy to handle any amount of data. Users can start

5. High Performance:
Producers, consumers, and brokers can all be scaled out to handle very large message streams with ease.


## Kafka Producer


ProducerRecord, which must

A **Kafka producer** has three mandatory

1. bootstrap.servers: This list doesn’t need to include all brokers, since

2. key.serializer: Name of a class that will be used to serialize the keys of the records we will produce

3. value.serializer: Name of a class that will be used to serialize the values of the records we will produce


```
Properties kafkaProps = new Properties();

```

There are three primary methods of sending msgs in kafka

1. **Fire-and-forget**

```

ProducerRecord<String, String> record =


```

2. **Synchronous send**

```
ProducerRecord<String, String> record =

```

3. Asynchronous send

>In


**Handling error in async scenerio**
<img src=https://media.giphy.com/media/a5viI92PAF89q/giphy.gif width="200">

```

private class DemoProducerCallback implements Callback {

```

## Message ACK 
**acks=0** :The producer will not wait for a reply from the broker before assuming the message

**acks=1** : The producer will receive a success response from the broker the moment the

**acks=all**: The producer will receive a success response from the broker once all in sync

> In order to maintain consistency, Kafka

## Important Producer config

1. linger.ms: By default, the producer will

2. buffer.memory: This config sets the amount of memory the producer will use to buffer messages waiting

3. compression.type: messages are sent uncompressed. This parameter can be set to snappy,



<img src=https://media.giphy.com/media/a5viI92PAF89q/giphy.gif width="200">
>Snappy compression was

> Gzip compression will typically use more CPU and time


4. batch.size: When multiple records are sent to the same partition, the producer will batch them

5. max.in.flight.requests.per.connection: This controls how many message batches the producer will send to the server without

### Ordering concern
```
Setting the retries parameter to nonzero and the max.in.

```

6. max.request.size

This setting controls the size of a produce request sent by the producer.with a default maximum request size

7. enable.idempotence: you can set enable.idempotence=true. When the idempotent producer

## Kafka and Avro love story

One of the most interesting features of Avro, and what makes it a good fit for use in a

Example:

```
## Schema 1

{"namespace": "customerManagement.avro",

## Schema 2

{"namespace": "customerManagement.avro",


```

The reading application will contain calls to methods similar to getName(), getId(),

Now suppose we upgrade our reading application and it no longer has the getFax

***Schema Registry pattern ***
The idea is to store all the schemas used to write data to Kafka in the registry. Then

###Partitioning in Kafka
Starting in the Apache Kafka

If a key exists and the default partitioner is used, Kafka will hash the key and use

### Quota mechanism and throttling

Kafka brokers have the ability to limit the rate at which messages are produced and

>When a client reaches its quota, the broker will start throttling the client’s requests to


### Reading Data from Kafka

#### consumer group:
Kafka consumers are typically part of a consumer group. When multiple consumers

![img.png](img.png)|![img_1.png](img_1.png)
:-------------------------:|:-------------------------:
![img_2.png](img_2.png)|![img_3.png](img_3.png)

Moving partition ownership from one consumer to another is called a **rebalance**.

There are **two types of rebalances**, depending on the partition assignment strategy

1. Eager rebalances: During an eager rebalance, all consumers **stop consuming**, **give up their ownership**

2. Cooperative rebalances: Cooperative rebalances (also called incremental rebalances) typically involve reassigning

>When a consumer wants to join a group, it sends a JoinGroup




