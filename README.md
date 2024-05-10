> [!NOTE]
> Although the repository is named as 'smartfit', the application was developed just for educational purposes to solve the challenge proposed [here](#https://github.com/bioritmo/front-end-code-challenge-smartsite) and is not intended for commercial use.

# 🌱 Smart Fit, an app built-in Angular and Spring Boot.

'Smart Fit' is a **CHALLENGE** application where users can search for open or closed units for consultation and booking underwent several changes during the pandemic. 

## Features

* Application's client-side built-in Angular 17
* Application's server-side as a restful service built-in Spring
* Spring Data JPA for data persistence
* PostgreSQL as relational database
* Docker and Docker-Compose configuration

> [!NOTE]
> W.I.P documentation

## Description

The application consists of allowing users to search for open and closed units to check their status around the pandemic. However, these units are described in the JSON file `https://test-frontend-developer.s3.amazonaws.com/data/locations.json`, and the loading of which is the responsibility of the API, which loads the units and proposes other functionalities that may be necessary over time.

By default, the JSON associated with the project is in the following format:

```json
{
  "current_country_id": <Integer>,
  "locations": <List<Object>>,
  "wp_total": <Integer>,
  "total": <Integer>,
  "success": <Boolean>
}
```

#

However, the list of objects in the `locations` field has two possible distinct types of objects:

**Unit:**
```json
{
  "id": 10998878976947,
  "title": "Ingá",
  "content": "\n<p>Rua Tiradentes,155 &#8211; Inga<br>Niterói, RJ</p>\n",
  "opened": true,
  "mask": "required",
  "towel": "required",
  "fountain": "partial",
  "locker_room": "partial",
  "schedules": [
    {
      "weekdays": "Seg. à Sex.",
      "hour": "06h às 21h"
    },
    {
      "weekdays": "Sáb.",
      "hour": "07h às 14h"
    },
    {
      "weekdays": "Dom.",
      "hour": "Fechada"
    }
  ]
},
```

**Address:**
```json
{
  "id": 1099887897633,
  "title": "Anchieta",
  "street": "Avenida Francisco Deslandes, 900",
  "region": "Anchieta",
  "city_name": "Belo Horizonte",
  "state_name": "Minas Gerais",
  "uf": "MG"
},
```

#

Therefore, the API persists under the collection of objects present in the units JSON and assigns them accordingly to the associated entities, storing the units in a database. With this service, it's possible to query `units` and `addresses` (untracked units) based on specific attributes. Although it's possible to directly consume the JSON file containing the registered units in the Angular application, it's more interesting to consume a RESTful service responsible for this, as some [features](#funcionalidades) are assigned.

### Features
- Loads units from the JSON file `https://test-frontend-developer.s3.amazonaws.com/data/locations.json`.
- Stores all tracked and untracked units.
- Retrieves all units.
- Retrieves units with filters.
- Retrieves units by attributes.
- Dynamically modifies unit information as needed.