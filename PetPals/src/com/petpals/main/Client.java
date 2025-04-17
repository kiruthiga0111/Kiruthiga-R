package com.petpals.main;

import com.petpals.model.Pet;
import com.petpals.dao.IPetDao;
import com.petpals.dao.PetDaoImpl;
import com.petpals.exceptions.*;

public class Client {
    public static void main(String[] args) {
        Pet pet1 = new Pet(20, "Jam", 3, "Labrador", "Dog");
        Pet pet2 = new Pet(21, "Wild", 2, "Persian", "Cat");
        Pet pet3 = new Pet(22, "Box", 4, "Beagle", "Dog");

        IPetDao petDao = new PetDaoImpl();

        petDao.addPet(pet1);
        petDao.addPet(pet2);
        petDao.addPet(pet3);

        petDao.updatePet(21, "Dabour");

        petDao.deletePet(20);

        Pet fetchedPet = petDao.getPetById(21);

        if (fetchedPet != null) {
            System.out.println("Pet Details:");
            System.out.println("ID: " + fetchedPet.getPetId());
            System.out.println("Name: " + fetchedPet.getName());
            System.out.println("Age: " + fetchedPet.getAge());
            System.out.println("Breed: " + fetchedPet.getBreed());
            System.out.println("Type: " + fetchedPet.getType());
        } else {
            System.out.println("No pet exists with the given ID.");
        }
    }
}
