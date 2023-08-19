## GCP load balancing ##
options span to four different layers (that is, data link, network, transport, and
application layers) of the OSI networking stack.

==> with persistent disks, you pay for the capacity that you allocate, whereas with cloud storage
buckets, you pay for the capacity that you actually use.

All billable resources are grouped into entities named projects.

-> Regions are geographical regions at the level of a subcontinent—the central US,
western Europe, or east Asia.
    |
     --> Zones are basically data centers within regions.
     --> Zones are analogous to Availability Zones in AWS
        

===> zones within the same region will typically have network latencies in the order of less than 5 milliseconds.
whereas across regions, those speeds will be slower.

A zone is a single point of failure in Google's data center network. Zones are analogous to Availability
Zones in AWS. If you replicate resources across different zones, such architecture can legitimately be termed as high-availability architecture

==> Cloud SQL and BigTable are regional
==> Cloud Spanner can be either regional or multiregional

Projects are set up within organizations,
and we will get to that hierarchy later on in the course. Projects are associated
with accounts and accounts with organizations. However, billing really happens
on a per project basis. Each project can be thought of as Resources + Settings +
Metadata.
A project is really associated with or defined by three pieces of metadata—the
name, ID, and the number. The project ID is unique and permanent. Even if you
go ahead and delete a project that ID will not be available for use for other
projects in the future.


A Cloud Shell is a machine instance
that runs on the Google Cloud which serves as your command line. All GCP
accounts have a Cloud Shell that they can use to access resources on the Google
Cloud Platform. You can access the Cloud Shell by clicking on a button to the
top right of the navigation ribbon

The cool thing about it is that you
can directly use the gcloud command-line tools to connect to resources in the
cloud, create resources, provision it, and so on.

In a nutshell, the Google Cloud Shell is a great tool for quick work on the
console. Remember, again, though, that it is a short, time-limited session on an
ephemeral VM. So, if you are going to be intensely developing on the Google
Cloud and you can download software, it's better to download the Google Cloud
SDK and use that instead. This offers a permanent connection to your instances
on the cloud instead of a temporary VM instance that has to be spun up in order
to use Cloud Shell.

