import org.junit.*;
import org.sql2o.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.DateFormat;
import java.util.Date;

public class SightingTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Deer", "healthy", "adult");
    testEndangeredAnimal.save();
    Sighting newSighting = new Sighting(testEndangeredAnimal.getId(), "45.472428, -121.946466", "Ranger Avery");
    assertEquals(true, newSighting instanceof Sighting);
  }

  @Test
  public void equals_returnsTrueIfLocationAndDescriptionAreSame_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Deer", "healthy", "adult");
    testEndangeredAnimal.save();
    Sighting testSighting = new Sighting(testEndangeredAnimal.getId(), "45.472428, -121.946466", "Ranger Avery");
    Sighting anotherSighting = new Sighting(testEndangeredAnimal.getId(), "45.472428, -121.946466", "Ranger Avery");
    assertTrue(testSighting.equals(anotherSighting));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Sighting() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Deer", "healthy", "adult");
    testEndangeredAnimal.save();
    Sighting testSighting = new Sighting (testEndangeredAnimal.getId(), "45.472428, -121.946466", "Ranger Avery");
    testSighting.save();
    assertEquals(true, Sighting.all().get(0).equals(testSighting));
  }

  @Test
  public void all_returnsAllInstancesOfSighting_true() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Deer", "healthy", "adult");
    testEndangeredAnimal.save();
    Sighting testSighting = new Sighting (testEndangeredAnimal.getId(), "45.472428, -121.946466", "Ranger Avery");
    testSighting.save();
    EndangeredAnimal secondTestEndangeredAnimal = new EndangeredAnimal("Badger", "malnourished", "young");
    secondTestEndangeredAnimal.save();
    Sighting secondTestSighting = new Sighting (testEndangeredAnimal.getId(), "45.472428, -121.946466", "Ranger Reese");
    secondTestSighting.save();
    assertEquals(true, Sighting.all().get(0).equals(testSighting));
    assertEquals(true, Sighting.all().get(1).equals(secondTestSighting));
  }

  @Test
  public void find_returnsSightingWithSameId_secondSighting() {
    EndangeredAnimal testAnimal = new EndangeredAnimal("Deer", "healthy", "adult");
    testAnimal.save();
    Sighting testSighting = new Sighting (testAnimal.getId(), "45.472428, -121.946466", "Ranger Avery");
    testSighting.save();
    EndangeredAnimal secondTestAnimal = new EndangeredAnimal("Badger", "malnourished", "young");
    secondTestAnimal.save();
    Sighting secondTestSighting = new Sighting (testAnimal.getId(), "45.472428, -121.946466", "Ranger Reese");
    secondTestSighting.save();
    assertEquals(Sighting.find(secondTestSighting.getId()), secondTestSighting);
  }

  @Test
  public void find_returnsNullWhenNoAnimalFound_null() {
    assertTrue(EndangeredAnimal.find(999) == null);
  }

}
