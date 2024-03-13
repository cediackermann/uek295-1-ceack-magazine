# Setup with Docker

## Prerequisites

1. Install Java 21
   via https://www.oracle.com/java/technologies/downloads/#java21
2. Install Docker via https://www.docker.com/products/docker-desktop/
3. Install Git via https://git-scm.com/book/en/v2/Getting-Started-Installing-Git

## Setup

### Setup Docker container

1. The following command will create a new Docker
   container with a PostgreSQL
   database. The database will be available on port 5432 and the password will
   be set to "postgres".
2. Start Docker Desktop and wait until it is running.

3. Enter the following command in your terminal:
```bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres --name uek295db postgres
```

3. Clone the repository via the following command in the terminal:

```bash
git clone https://github.com/cediackermann/uek295-1-ceack-magazine.git
```

5. Open the project in your favorite IDE (e.g. IntelliJ IDEA) and let the
   dependencies be installed.
6. Run the file `magazine/src/main/java/ch/noseryoung/MagazineApplication.java`
   to start the application.

Open http://localhost:8080/swagger-ui/index.html#/magazine-controller/getMagazineById
in your browser to see the API documentation. You can maintain Users in the
file `magazine/src/main/resources/data.sql`.