# Wildlife Tracker

An app for the forest service to track animals for an environmental impact study.

#### By _**Witty Chang**_


### Description

The Forest Service is considering a proposal from a timber company to clear-cut a nearby forest of Douglas Fir. Before this proposal may be approved, they must complete an environmental impact study. This application was developed to allow Rangers to track wildlife sightings in the area.

### What's Included

```
java-wildlife-tracker
    ├── README.md
    ├── build.gradle
    ├── .gitignore
    └── src
         ├── main
         │     ├── java
         │     │     ├── Animal.java
         │     │     ├── App.java
         │     │     ├── DB.java
         │     │     ├── EndangeredAnimal.java
         │     │     ├── LeastConcernAnimal.java
         │     │     ├── Sighting.java
         │     │     └── VelocityTemplateEngine.java
         │     └── resources
         │             ├── public
         |             |      ├── app.css
         |             |      └── background.jpg
         │             └── templates
         │                    ├── animal-form.vtl
         │                    ├── animal.vtl
         │                    ├── endangered_animal.vtl
         │                    ├── error.vtl
         │                    ├── index.vtl
         │                    ├── layout.vtl
         │                    └── success.vtl
         └── test
               └── java
                     ├── AnimalTest.java
                     ├── DatabaseRule.java
                     ├── EndangeredAnimalTest.java
                     ├── LeastConcernAnimalTest.java
                     └── SightingTest.java
```

## Setup/Installation Requirements

You will need [gradle](https://gradle.org/gradle-download/) and PostgreSQL installed on your device.

Enter the following commands in your terminal:
* `$ git clone https://github.com/wcchang1382/wildlife-tracker`;
* In a new terminal window, `$ postgres` to start the PostgreSQL server;
* In another terminal window, `$ psql` to launch PSQL.

In PSQL:
* `CREATE DATABASE wildlife_tracker;`
* `\c wildlife_tracker;`
* `CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar);`
* `CREATE TABLE endangered_animals (id serial PRIMARY KEY);`
* `CREATE TABLE leastconcern_animals (id serial PRIMARY KEY);`
* `CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, location varchar, ranger_name varchar);`
* `CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;`

Go back to your terminal window and enter the following:
* `gradle run` to run the application;
* View http://localhost:4567 in a web browser of your choice.

## Support and contact details

Please feel free to contact wcc1213@gmail.com if you have any questions, issues, concerns, comments or suggestions.

## Technologies Used

* Java
* jUnit
* Gradle
* PostgreSQL
* Spark

### License

_Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE._

Copyright (c) 2017 **_Witty Chang_**
