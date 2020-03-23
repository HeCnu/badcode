package ru.liga.intership.badcode.domain;



public class Person {
    private Long id;
    private String sex;
    private String name;
    private Long age;
    private Long weight;
    private Long height;


    public Person() {
    }

    public Long getId() {
        return id;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Person setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Long getWeight() {
        return weight;
    }

    public Person setWeight(Long weight) {
        this.weight = weight;
        return this;
    }

    public Long getHeight() {
        return height;
    }

    public Person setHeight(Long height) {
        this.height = height;
        return this;
    }

    public Long getAge() {
        return age;
    }

    public Person setAge(Long age) {
        this.age = age;
        return this;
    }
}
