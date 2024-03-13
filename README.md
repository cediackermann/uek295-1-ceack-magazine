# Setup with Docker

## Prerequisites

1. Install Java 21
   via https://www.oracle.com/java/technologies/downloads/#java21
2. Install Docker via https://www.docker.com/products/docker-desktop/

## Setup

1. Setup Docker container
   The following command will create a new Docker container with a PostgreSQL
   database. The database will be available on port 5432 and the password will
   be set to "postgres".

```bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres --name uek295db postgres
```

2. Clone the repository

```bash
git clone https://github.com/cediackermann/uek295-1-ceack-magazine.git
```

3. Run the file `magazine/src/main/java/ch/noseryoung/MagazineApplication.java`
   in the database to
   create the tables and insert the initial data.

Open http://localhost:8080/swagger-ui/index.html#/magazine-controller/getMagazineById
in your browser to see the API documentation. You can maintain Users in the
file `magazine/src/main/resources/data.sql`.