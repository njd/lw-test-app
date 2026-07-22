# Test Application

## What's Here

Most of the requirements are met. I did attempt to map the entities to DTOs in the service layer, but couldn't
get all the tests working properly; so that's on the `dtos-broken` branch.

Basically there's a HomeController which lists the data, if the app is connected to an obliging Postgres database.  
There's configuration in the `application.properties` file

In the `main` branch, the service layer returns entities to the controller, which isn't ideal, but it works.

I did also attempt to add Spring Security authentication and a login page, but I backed that out too.

## Running

Set the following environment variables:

- DBNAME
- POSTGRES_USER
- POSTGRES_PASSWORD

And run the application with:
```
mvn spring-boot:run
```

## Tests

Unit tests can be run with
```
mvn test
```

Integration tests can be run with:
```
mvn verify
```

If you have an external (populated) postgres database, you can set the environment variables:
 - DBNAME
 - POSTGRES_USER
 - POSTGRES_PASSWORD
 
and then run:
```
mvn -Pexternal verify
```
To run non-destructive DataJPA tests against the database.  
These tests mainly prove the functionality in the JPA repository.