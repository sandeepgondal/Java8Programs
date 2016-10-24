package com.sandy.java8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamsClass {

    public static void main(String[] args) {
        List<Person> persons = createData();

        // Get all persons having age greater than 10
        System.out.println(
            persons.stream()
                    .filter(p -> p.getAge() > 10)
                    .collect(toList()));

        // get all unique person names
        System.out.println(
                persons.stream()
                        .map(Person::getName)
                        .collect(toSet())
        );

        // get a multimap where key is name and value is Person
        System.out.println(
                persons.stream()
                        .collect(groupingBy(Person::getName))
        );

        // get a multimap where key is name and value is List of age
        System.out.println(
                persons.stream()
                        .collect(groupingBy(Person::getName, mapping(Person::getAge, toList())))
        );

        // get average age
        System.out.println(
                persons.stream()
                        .mapToInt(Person::getAge)
                        .average()
        );
    }

    static private List<Person> createData() {
        return Arrays.asList(
            new Person("Sandeep", 34, Gender.MALE),
            new Person("Smita", 31, Gender.FEMALE),
            new Person("Vivaan", 4, Gender.MALE),
            new Person("Sandeep", 2, Gender.MALE),
            new Person("Vivaan", 12, Gender.MALE)
        );
    }

    static private class Person {
        private String name;
        private int age;
        private Gender gender;

        public Person(final String name, final int age, final Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(final int age) {
            this.age = age;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(final Gender gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }

    static enum Gender {
        MALE,
        FEMALE
    }

}
