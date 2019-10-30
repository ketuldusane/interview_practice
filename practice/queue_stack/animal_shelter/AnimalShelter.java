import java.util.LinkedList;

public class AnimalShelter {
  LinkedList<Dog> dogs = new LinkedList<>();
  LinkedList<Cat> cats = new LinkedList<>();
  private int order = 0;

  public static void main(String[] args) {
    AnimalShelter a = new AnimalShelter();
    a.enqueue(new Dog("a"));
    a.enqueue(new Cat("b"));
    a.enqueue(new Cat("c"));
    a.enqueue(new Dog("d"));
    System.out.println(a.dequeueCats().name);
  }

  public void enqueue(Animal a) {
    a.setOrder(order);
    order++;

    if (a instanceof Dog) { dogs.add((Dog) a); }
    else { cats.add((Cat) a); }
  }

  public Animal dequeueAny() {
    if (dogs.size() == 0) {
      return dequeueCats();
    } else if (cats.size() == 0) {
      return dequeueCats();
    }

    Dog dog = dogs.peek();
    Cat cat = cats.peek();
    if (dog.isOlderThan(cat)) {
      return dequeueDogs();
    } else {
      return dequeueCats();
    }
  }

  public Animal dequeueDogs() {
    return dogs.poll();
  }

  public Animal dequeueCats() {
    return cats.poll();
  }
}
