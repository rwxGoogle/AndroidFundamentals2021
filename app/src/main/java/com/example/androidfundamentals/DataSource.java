package com.example.androidfundamentals;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    class Person {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        private String age;
    }

    public List<String> getPhotoList() {
        List<String> photos = new ArrayList();
        photos.add("Photos1");
        photos.add("Photos2");
        photos.add("Photos3");
        photos.add("Photos4");
        photos.add("Photos5");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos1");
        photos.add("Photos2");
        photos.add("Photos3");
        photos.add("Photos4");
        photos.add("Photos5");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos1");
        photos.add("Photos2");
        photos.add("Photos3");
        photos.add("Photos4");
        photos.add("Photos5");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        photos.add("Photos6");
        return photos;
    }

    public List<Person> getPersons() {
        Person person = new Person();
        person.setName("Roxana");
        person.setAge("29");

        Person person1 = new Person();
        person1.setName("Mihai");
        person1.setAge("30");

        List<Person> personList = new ArrayList();
        personList.add(person);
        personList.add(person1);

        return personList;
    }
}
