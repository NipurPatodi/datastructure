## AWS LAMBDA ##
AWS Lambda is a serverless computing service provided by Amazon Web Services (AWS). Users of AWS Lambda create functions, self-contained applications written in one of the supported languages and runtimes, and upload them to AWS Lambda, which executes those functions in an efficient and flexible manner.

The Lambda functions can perform any kind of computing task, from serving web pages and processing streams of data to calling APIs and integrating with other AWS services.

Lambda work on container -- so cold start

Each Lambda function runs in its own container. When a function is created, Lambda packages it into a new container and then executes that container on a multi-tenant cluster of machines managed by AWS

The customers then get charged based on the allocated memory and the amount of run time the function took to complete.

One of the distinctive architectural properties of AWS Lambda is that many instances of the same function, or of different functions from the same AWS account, can be executed concurrently.

**We can 100% serverless**

Typically, to complete a Serverless stack you’ll need:

a computing service;
a database service; and
an HTTP gateway service.
Lambda fills the primary role of the compute service on AWS. It also integrates with many other AWS services and, together with API Gateway, DynamoDB and RDS, forms the basis for Serverless solutions for those using AWS. Lambda supports many of the most popular languages and runtimes, so it’s a good fit for a wide range of Serverless developers.


## Most common use case for Lamba **

Try to see these pattern
1. Task is self contain and short living
2. There is very high difference between low and high work load of system.

Example of lambda

1. Scalable API : When building APIs using AWS Lambda, one execution of a Lambda function can serve a single HTTP request. Different parts of the API can be routed to different Lambda functions via Amazon API Gateway. AWS Lambda automatically scales individual functions according to the demand for them, so different parts of your API can scale differently according to current usage levels. This allows for cost-effective and flexible API setups.

2. Data processing: Lambda functions are optimized for event-based data processing 
-It is easy to integrate AWS Lambda with datasources like Amazon DynamoDB and trigger a Lambda function for specific kinds of data events. For example, you could employ Lambda to do some work every time an item in DynamoDB is created or updated, thus making it a good fit for things like `notifications`, `counters` and `analytics`.

3. Task automation : This might include running scheduled jobs that perform cleanup in your infrastructure, processing data from forms submitted on your website, or moving data around between different datastores on demand.

Very good functionally 
```
Automatic scaling. AWS Lambda creates the instances of your function as they are requested. There is no pre-scaled pool, no scale levels to worry about, no settings to tune—and at the same time your functions are available whenever the load increases or decreases. You only pay for each function’s run time.
```

## Problem with lambda ##
1. **Cold start time**: When a function is started in response to an event, there may be a small amount of latency between the event and when the function runs. If your function **hasn’t been used in the last 15 minutes**, the latency can be **as high as 5-10 seconds**, making it hard to rely on Lambda for latency-critical applications. There are ways to work around it,

2. Function limits: A Lambda function will **time out after running for 15 minutes**. There is **no way to change this** limit. If running your function typically takes more than 15 minutes, AWS Lambda might not be a good solution for your task.

The options for the amount of **RAM available** to the Lambda functions range from **128MB to 3,008MB with a 64MB** step.


The **zipped** Lambda code package should not **exceed 50MB** in size, and the **unzipped** version shouldn’t be larger than **250MB**

**concurrent execution** for all AWS Lambda functions within a single AWS account are limited to 1,000 - this is as good as only 1000 lambda can run llarally  or 1000 instance , this can be increase by contacting support

Any Lambda executions triggered above your concurrency limit will be throttled and will be forced to wait until other functions finish running.

When using **Amazon API Gateway** to trigger Lambda functions in response to HTTP requests (i.e. when building a web application), the **maximum payload size** that API Gateway can handle is **10MB**.

Calculation example :

ex 1. **Lambda can be croned** also - Simple use case is to rollup DB using AWS Lambda
job runs for 10 mins and take 1 gb   total  
30 days * 600 GB-sec = 18000 GB Sec
request  30 monthly ( 1 req per day )  so it is all free


ex 2.**API Layer** :
10000 Active user  and 100 API request per day per user 
1 second per request and 512 MB per request
Total compute: 30 days x 10,000 users x 100 requests x 0.5GB RAM x 1 second = 15,000,000 GB-seconds
Total requests:  30 days x 10,000 users x 100 requests = 30,000,000 requests 


For the 30M requests you’ll pay 30 x $0.20/1M requests = $6/month on AWS Lambda.
‍
All these requests go through Amazon API Gateway, so there for the 30M requests you’ll pay 30 x $3.50/1M requests = $105/month on API Gateway.
‍
For the monthly 15M GB-seconds of compute on AWS Lambda you’ll pay 15M * $0.0000166667/GB-second ~= $250/month.
‍
So the total cost of the API layer will be around $360/month with this load.

**Can AWS Lambda call another Lambda **
yes 1. direct invokation 2, by using even written to AWS SNS 3. AWS Step functions


**Monitoring Lambda functions with AWS CloudWatch**
 