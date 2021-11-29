##System Design by doordash ##
### How to start ###
1. Take a deep breath and relax!
2. Don't jump to design right away
3. Ask a significant number of clarifying questions.
4. scope of the problem ( Focus on main don't design every thing)
5. **Identify the users (actors)** of your application.\
   This is important because companies like Amazon obsess over the customer.\
   You will earn brownie points if you are able to specify the actors \
   
6. Talk about scale and growth of data.
7. Think out loud

### Component Design ###
The overall architecture could be microservices-based with heavy usage of the publisher-subscriber pattern, involving a queuing technology like Kafka, RabbitMQ, ActiveMQ, Amazon SNS, or Amazon MQ\

it is imperative that each microservice interacts with its own database and doesn’t share with anyone else. This approach is motivated by the database-per-service paradigm

### Search ecosystem ###
1. a personalized discovery and search experience based on a customer’s past search and order history must be provided.\
   We can think of leveraging popular off-the-shelf search offerings from the market, such as Elasticsearch or Apache Solr, for quick lookup as per user search parameters \
   
Micro service model where each service 
subscribe to Queue
and publish to queue

ETA calculation using Isochrones


### Security ###
HTTPS/SSL -TLS for securing the wire. \
All communications between the web or mobile clients need to be on TLS.

OAuth 2.0 for token authorisation/refresh/generation - For authorization not authentication
https://www.varonis.com/blog/what-is-oauth/ 


for kafka use SASL (Kerberos)+ TSL
https://en.wikipedia.org/wiki/Simple_Authentication_and_Security_Layer

`The crashed node can then do a cleanup and restart using a process called self-healing.`


