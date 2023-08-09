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



