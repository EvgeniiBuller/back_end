import java.util.ArrayList;

import java.util.List;


public class Main {

    /*Дано: список Person
    Необходимо: написать метод, который определит, есть ли Person с заданным именем в списке*/

    public static void main(String[] args) {
List<Person> list = new ArrayList<>();
        list.add(new Person("Jack", 20));
        list.add(new Person("Anna", 22));
        list.add(new Person("Igor", 19));
        list.add(new Person("Mike", 24));
        list.add(new Person("Nick", 23));

        System.out.println(ifPersonWithNameExsist(list, "Igor")); //true
        System.out.println(ifPersonWithNameExsist(list, "Lena")); //false

    }

    public  static  boolean ifPersonWithNameExsist(List<Person> list, String name) {
        for (Person person: list) {
            if (person.getName().equalsIgnoreCase(name)) {
                return  true;
            }
        }
        return  false;
    }




}
