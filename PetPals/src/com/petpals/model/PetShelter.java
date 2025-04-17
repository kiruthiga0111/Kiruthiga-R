// File: com/petpals/model/PetShelter.java
package com.petpals.model;

import com.petpals.dao.IAdoptable;
import java.util.ArrayList;
import java.util.List;

public class PetShelter implements IAdoptable {

    private List<Pet> pets = new ArrayList<>();

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void listAvailablePets() {
        if (pets.isEmpty()) {
            System.out.println("No pets available for adoption.");
            return;
        }
        for (Pet p : pets) {
            try {
                if (p.getName() == null || p.getAge() == 0) {
                    throw new NullPointerException();
                }
                System.out.println(p);
            } catch (NullPointerException e) {
                System.out.println("Pet information missing.");
            }
        }
    }

    @Override
    public void adopt() {
        System.out.println("Pet adopted from shelter.");
    }
}
