import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
  public String name;
  public int id;
  public String health;
  public String age;
  public String type;

// Remove Animal constructor because Animal becomes an abstract class.
  // public Animal(String name) {
  //   this.name = name;
  //   this.id = id;
  // }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public String getHealth() {
    return health;
  }

  public String getAge() {
    return age;
  }

  public String getType() {
    return type;
  }

  // @Override
  // public boolean equals(Object otherAnimal) {
  //   if(!(otherAnimal instanceof Animal)) {
  //     return false;
  //   } else {
  //     Animal newAnimal = (Animal) otherAnimal;
  //     return this.getName().equals(newAnimal.getName());
  //   }
  // }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, health, age, type) VALUES (:name, :health, :age, :type);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("health", this.health)
        .addParameter("age", this.age)
        .addParameter("type", this.type)
        .executeUpdate()
        .getKey();
    }
  }

  // public static List<Animal> all() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM animals;";
  //     return con.createQuery(sql)
  //       .executeAndFetch(Animal.class);
  //   }
  // }
  //
  // public static Animal find(int id) {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM animals WHERE id=:id;";
  //     Animal animal = con.createQuery(sql)
  //       .addParameter("id", id)
  //       .executeAndFetchFirst(Animal.class);
  //     return animal;
  //   }
  // }

  public void updateName(String name) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET name=:name WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .addParameter("name", name)
        .executeUpdate();
    }
  }

  public void updateHealth(String health) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET health=:health WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .addParameter("health", health)
        .executeUpdate();
    }
  }

  public void updateAge(String age) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET age=:age WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("age", age)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM animals WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public List<Sighting> getSightings() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE animal_id=:id;";
        List<Sighting> sightings = con.createQuery(sql)
          .addParameter("id", id)
          .executeAndFetch(Sighting.class);
      return sightings;
    }
  }

}
