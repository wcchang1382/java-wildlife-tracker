import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class LeastConcernAnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void leastConcernAnimal_instantiatesCorrectly_true() {
    LeastConcernAnimal testLeastConcernAnimal = new LeastConcernAnimal("Fox", "Healthy", "Young");
    assertEquals(true, testLeastConcernAnimal instanceof LeastConcernAnimal);
  }

  @Test
  public void getHealth_returnsHealthAttribute_true() {
    LeastConcernAnimal testLeastConcernAnimal = new LeastConcernAnimal("Fox", "Healthy", "Young");
    assertEquals("Healthy", testLeastConcernAnimal.getHealth());
  }

  @Test
  public void save_assignsIdAndSavesObjectToDatabase() {
    LeastConcernAnimal testLeastConcernAnimal = new LeastConcernAnimal("Fox", "Healthy", "Young");
    testLeastConcernAnimal.save();
    LeastConcernAnimal savedLeastConcernAnimal = LeastConcernAnimal.all().get(0);
    assertEquals(testLeastConcernAnimal.getId(), savedLeastConcernAnimal.getId());
  }

  @Test
  public void all_returnsAllInstancesOfLeastConcernAnimal_true() {
    LeastConcernAnimal firstLeastConcernAnimal = new LeastConcernAnimal("Fox", "Healthy", "Young");
    firstLeastConcernAnimal.save();
    LeastConcernAnimal secondLeastConcernAnimal = new LeastConcernAnimal("Badger", "Okay", "Adult");
    secondLeastConcernAnimal.save();
    assertEquals(true, LeastConcernAnimal.all().get(0).equals(firstLeastConcernAnimal));
    assertEquals(true, LeastConcernAnimal.all().get(1).equals(secondLeastConcernAnimal));
  }

  @Test
  public void find_returnsAnimalWithSameId_secondAnimal() {
    LeastConcernAnimal firstLeastConcernAnimal = new LeastConcernAnimal("Fox", "Healthy", "Young");
    firstLeastConcernAnimal.save();
    LeastConcernAnimal secondLeastConcernAnimal = new LeastConcernAnimal("Badger", "Okay", "Adult");
    secondLeastConcernAnimal.save();
    assertEquals(LeastConcernAnimal.find(secondLeastConcernAnimal.getId()), secondLeastConcernAnimal);
  }

  @Test
  public void update_updatesHealthAttribute_true() {
    LeastConcernAnimal testLeastConcernAnimal = new LeastConcernAnimal("Fox", "Healthy", "Young");
    testLeastConcernAnimal.save();
    testLeastConcernAnimal.updateHealth("ill");
    assertEquals("ill", LeastConcernAnimal.find(testLeastConcernAnimal.getId()).getHealth());
  }

  @Test
  public void update_updatesAgeAttribute_true() {
    LeastConcernAnimal testLeastConcernAnimal = new LeastConcernAnimal("Fox", "Healthy", "Young");
    testLeastConcernAnimal.save();
    testLeastConcernAnimal.updateAge("Adult");
    assertEquals("Adult", LeastConcernAnimal.find(testLeastConcernAnimal.getId()).getAge());
  }
}
