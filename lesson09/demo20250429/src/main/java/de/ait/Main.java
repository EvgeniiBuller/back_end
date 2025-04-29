package de.ait;

public class Main {
    public static void main(String[] args) {

        Person p = new Person("Jack", 10, 20, 105);
        int w = p.getWeight();
        System.out.println(p);

        Person mike = Person.builder()
                .name("Mike")
                .weight(20)
                .age(31)
                .build();
        System.out.println(mike);
    }
}