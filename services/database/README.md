# 🌱 Smartfit Database, a relational database running in Postgres.

'Smartfit Database' is the database able to receive and persist application data, like Smartfit's units. 

## Features

* PostgreSQL as relational database management system

## Summary

- [Requirements](#requirements)
- [Running](#running)

## Requirements
The database needs to run as a multi-container application if you want to avoid additional configuration. For this, you need to use **Docker Engine** (for Linux) or **Docker Desktop** (for MacOS & Windows).

If you want to run it manually, you need to run all services manually:

First, modify `spring.datasource.url` at API's [application.properties](https://github.com/avila-r/smartfit/blob/main/services/smartfit/src/main/resources/application.properties) defining value `jdbc:postgresql://localhost:{database_port}/{database_name}`. 

Then, modify `url` field at [`UnitsService`](https://github.com/avila-r/smartfit/blob/main/services/client/src/app/services/units.service.ts), defining value `"http://localhost:{api_port}/locations"`.

## Running

### Run at a multi-container application

Make sure that Docker and Docker-Compose are locally configured, then you can run the multi-container application defined in __smartfit/docker-compose.yml__ on your local machine.

**1. Clone Repository:**
```bash
$ git clone https://github.com/avila-r/smartfit && cd smartfit
```

**2. Run Docker Compose:**

```bash
$ docker compose up --build --force-recreate
```

Then your local machine will build all images. The database container `smartfitdb` will run by default on port `5432`. It's not recommended to change it if you want to avoid additional configuration.

### Run manually

Make sure that PostgreSQL are locally installed and configured. For default, it's recommended defining `postgres` as your user and `123` as your password, but you can change it if it's able to define additional configuration. If you want to define your preferences, just change attributes at API's [application.properties](https://github.com/avila-r/smartfit/blob/main/services/smartfit/src/main/resources/application.properties).

**1. Create database:**
```sql
CREATE DATABASE database_name;
```

**2. Get schema:**

You can get SQL generation at [here](https://github.com/avila-r/smartfit/blob/main/services/database/init.sql). Just copy it and execute.

```sql
create table units
(
    id                 bigint      not null
        constraint locations_pkey
            primary key,
    title              varchar(50) not null,
    content            text        not null,
    is_opened          boolean     not null,
    mask_status        varchar(15) not null,
    towel_status       varchar(15) not null,
    fountain_status    varchar(15) not null,
    locker_room_status varchar(15) not null
);

create table schedules
(
    id       serial
        primary key,
    unit_id  bigint
        constraint schedules_location_id_fkey
            references units,
    weekdays text not null,
    hour     text not null
);

create table addresses
(
    id         bigint       not null
        primary key,
    title      varchar(50)  not null,
    street     varchar(100) not null,
    region     varchar(50)  not null,
    city_name  varchar(50)  not null,
    state_name varchar(50)  not null,
    uf         varchar(4)   not null
);
```

Now, if your database is uptime locally, you can run [smartfit](https://github.com/avila-r/smartfit/tree/main/services/smartfit) service.