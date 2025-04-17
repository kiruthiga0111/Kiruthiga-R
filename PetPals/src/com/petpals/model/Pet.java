package com.petpals.model;

public class Pet {
    private int petId;
    private String name;
    private int age;
    private String breed;
    private String type;

    public Pet(int petId, String name, int age, String breed, String type) {
        this.petId = petId;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.type = type;
    }

    public int getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getType() {
        return type;
    }
}
