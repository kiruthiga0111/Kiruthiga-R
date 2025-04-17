package com.petpals.dao;

import com.petpals.model.Pet;
import java.util.List;

public interface IPetDao {
    void addPet(Pet pet);
    void updatePet(int pet_id, String newBreed);
    void deletePet(int pet_id);
    Pet getPetById(int pet_id);
    List<Pet> getAllPets();
}
