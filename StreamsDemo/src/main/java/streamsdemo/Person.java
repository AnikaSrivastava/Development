package streamsdemo;

import java.util.List;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    static void addPersons(List<Person> persons) {
        Person person1 = new Person(10, "Andy");
        Person person2 = new Person(20, "Jane");
        Person person3 = new Person(30, "Andrew");
        Person person4 = new Person(18, "Arica");
        Person person5 = new Person(25, "Jane");
        Person person6 = new Person(3, "Bob");
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
    }

    @Override
    public String toString() {
        return "demo.Person " + name + " " + age;
    }
}
