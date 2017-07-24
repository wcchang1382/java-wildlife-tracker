import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class LeastConcernAnimal extends Animal{
  private String health;
  private String age;
  public static final DATABASE_TYPE = "leastconcern";

  public LeastConcernAnimal(String name, String health, String age) {
    this.name = name;
    this.id = id;
    this.health = health;
    this.age = age;
    this.type = DATABASE_TYPE;
  }

  @Override
  public boolean equals(Object otherLeastConcernAnimal) {
    if(!(otherLeastConcernAnimal instanceof LeastConcernAnimal)) {
      return false;
    } else {
      LeastConcernAnimal newLeastConcernAnimal = (LeastConcernAnimal) otherLeastConcernAnimal;
      return this.getId() == newLeastConcernAnimal.getId() &&
             this.getName().equals(newLeastConcernAnimal.getName()) &&
             this.getHealth().equals(newLeastConcernAnimal.getHealth()) &&
             this.getAge().equals(newLeastConcernAnimal.getAge());
    }
  }

  public static List<LeastConcernAnimal> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE type = 'endangered';";
      return con.createQuery(sql)
        .executeAndFetch(LeastConcernAnimal.class);
    }
  }

  public static LeastConcernAnimal find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE id=:id;";
      LeastConcernAnimal endangeredanimal = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(LeastConcernAnimal.class);
      return endangeredanimal;
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
