![Initial draft of infrastructure on AWS cloud](littil-aws-infra-v0.1.png "Initial draft of infrastructure on AWS cloud")

Note: Diagram contains draw.io source (load diagram from this PNG image)

AWS Feedback 2022-09-13:
- Use Amplify for front-end. Hosting & Build in AWS in a cost-effective way
  - Pay per build-minute & gigabyte storage & gigabyte traffic
  - Free tier eligible
- ECR (Elastic Container Registry) for image storage
  - Pay for storage, use expiry date on images to save on storage
  - Use ECR vulnerability scanning (setting in ECR, functionality from Security Hub)
- Load balancer for back-end ingress
  - Only way to get traffic dynamically routed. Elastic IP is free of charge, but requires manual DNS updates to internal container IP
- ECS (Elastic Container Service) for back-end runtime
  - ARM or x86, ARM is cheaper (native compilation with Quarkus?)
  - Fargate
- Networking
  - Private subnet, VPC with 2 AZ (Availability Zones)
  - NAT Gateway for egress (to retrieve images from ECR)
- CDK
  - Use aws_ecs_patterns in TypeScript CDK, network details will be abstracted away
- RDS (Relational Database Service) for persistence
  - EC2 instance T4G-micro, 2vCPU, 1GB, good for ~89 DB connections

Decisions on start of implementation front-end infra 2022-09-24
- Use Cloudfront & S3 for front-end. Amplify would use those anyway, and could be useful. But for now it adds unnecessary complexity.
