# 🌱 Smartfit API, a RESTful service built-in Spring Boot.

'Smartfit API' is an API able to retrieve Smartfit's units for consultation and booking. 

## Features

* Spring-Boot Application
* Spring Data JPA for data persistence
* Jackson library implementation for reading JSON
* PostgreSQL as relational database 
* Dockerfile for image build

## Summary

- [Requirements](#requirements)
- [Testing](#testing)

## Requirements
The application needs to run as a multi-container application using **Docker Engine** (for Linux) or **Docker Desktop** (for MacOS & Windows). If you want to run it manually, you need additional (and unsupported) configuration.

## Testing

### Run at a multi-container application

Make sure that Docker and Docker-Compose are locally configured, then you can run the multi-container application defined in __smartfit/docker-compose.yml__ on your local machine.

**Clone Repository**
```bash
$ git clone https://github.com/avila-r/smartfit && cd smartfit
```

**Run Docker Compose**

```bash
$ docker compose up --build --force-recreate
```

Then your local machine will build all images. The smartfit-api container will bun by default on port `8080`. If you want to modify it, configure the port by changing in __docker-compose.yml__, then modify `url` attribute of `UnitsService` at __services/client/src/app/services/units-service.ts__.

### Endpoints

> [!NOTE]
> This is a W.I.P documentation and endpoints is still not documented. If you need to see the configuration of mapped endpoints, search by defined [controllers](https://github.com/avila-r/smartfit/tree/main/services/smartfit/src/main/java/com/avila/smartfit/controller)