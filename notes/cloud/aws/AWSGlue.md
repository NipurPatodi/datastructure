# AWS Glue 

AWS Glue is simply a serverless ETL tool. ETL refers to three (3) processes that are commonly needed in most Data Analytics / Machine Learning processes: Extraction, Transformation, Loading. Extracting data from a source, transforming it in the right way for applications, and then loading it back to the data warehouse. And AWS helps us to make the magic happen. 

Component of GLue:

Data catalog: The data catalog holds the metadata and the structure of the data.
Database: It is used to create or access the database for the sources and targets.
Table: Create one or more tables in the database that can be used by the source and target.
Crawler and Classifier: A crawler is used to retrieve data from the source using built-in or custom classifiers. It creates/uses metadata tables that are pre-defined in the data catalog.
Job: A job is business logic that carries out an ETL task. Internally, Apache Spark with python or scala language writes this business logic.
Trigger: A trigger starts the ETL job execution on-demand or at a specific time.
Development endpoint: It creates a development environment where the ETL job script can be tested, developed, and debugged.


Why Glue ?

AWS Glue scan through all the available data with a crawler
Final processed data can be stored in many different places (Amazon RDS, Amazon Redshift, Amazon S3, etc)
It’s a cost-effective option as it’s a serverless ETL service
It’s fast. It gives you the Python/Scala ETL code right off the bat.


ETL, Extract, Transform and Load workloads are becoming popular lately. An increasing number of companies are looking for solutions to solve their ETL problems. Moving data from one datastore to another can become a really expensive solution if the right tools are not chosen. AWS Glue provides easy to use tools for getting ETL workloads done. AWS Glue runs your ETL jobs in an Apache Spark Serverless environment, so you are not managing any Spark clusters by yourself.

# AWS Athena

Amazon Athena
On 20 November 2016, Amazon launched Athena as one of its services. As mentioned earlier, Amazon Athena is a serverless query service that analyzes data using standard SQL stored in Amazon S3. With a few clicks in the AWS Management Console, customers can point Amazon Athena at their data stored in Amazon S3 and run queries using standard SQL to retrieve results in seconds.

With Amazon Athena, there is no infrastructure to set up or manage, and the customer only pays for the queries they run. Amazon Athena scales automatically, executing queries in parallel, giving fast results even with large datasets and complex queries.

 **-->Athena verse Hive**
 https://www.projectpro.io/compare/amazon-athena-vs-apache-hive
 
 
 Redshift 
 AWS Datawarehouse
 
 