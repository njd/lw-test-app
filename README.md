# Test Application

## Running

Run the application with:
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
These test mainly prove the functionality in the JPA repository.