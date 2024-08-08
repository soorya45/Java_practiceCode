
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Test9_1 {
    public static void main(String[] args) {
        // Creating an array of Person objects
        Person[] people = new Person[3];


        // Initializing the array with Person objects
        people[0] = new Person("Alice", 25);
        people[1] = new Person("Bob", 30);
        people[2] = new Person("Charlie", 22);


        // Accessing and displaying information from the array
        for (Person person : people) {
            person.display();
        }
    }
}
