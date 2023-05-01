
# Web-sec-impl
Session based web security implementaion with Spring security. Users are taken from Postgres database with Spring Data JPA.

### Website
Default website is loaded on 
```txt
http://localhost:8080/
```
And all other endpoints are secured.

### Roles
The security implementaion implements two roles - user and admin. In this project, one can have only one role. For implementaion of separate role table, visit my
[jwt-auth-impl](https://github.com/jakvitov/jwt-auth-impl)
project.








## API Reference
Besies serving static content, the server also has simple secured API to test endpoint security.

#### Greet everyone

```http
  GET /greet
```
Permitted to everybody, with universal greeting.

#### Greet user

```http
  GET /user/greet
```
Greeting permitted to user role.

#### Greet admin

```http
  GET /admin/greet
```
Greeting permitted to admin role.


## Authors

- [@jakvitov](https://www.github.com/jakvitov)


## License
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)

