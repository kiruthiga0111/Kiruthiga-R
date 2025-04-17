package com.petpals.dao;

import com.petpals.model.Pet;
import com.petpals.util.DbConnectionUtil;
import com.petpals.exceptions.PetNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDaoImpl implements IPetDao {
    static Connection connection;

    @Override
    public void addPet(Pet pet) {
        connection = DbConnectionUtil.getConnection();
        String sql = "INSERT INTO pet (pet_id, name, age, type, breed) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pet.getPetId());
            statement.setString(2, pet.getName());
            statement.setInt(3, pet.getAge());
            statement.setString(4, pet.getType());
            statement.setString(5, pet.getBreed());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, statement, connection);
        }
    }

    @Override
    public void updatePet(int pet_id, String newBreed) {
        connection = DbConnectionUtil.getConnection();
        String sql = "UPDATE pet SET breed = ? WHERE pet_id = ?";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, newBreed);
            statement.setInt(2, pet_id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new PetNotFoundException("Pet with ID " + petId + " not found for update.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, statement, connection);
        }
    }

    @Override
    public void deletePet(int petId) {
        connection = DbConnectionUtil.getConnection();
        String sql = "DELETE FROM pet WHERE petId = ?";
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, petId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new PetNotFoundException("Pet with ID " + petId + " not found for deletion.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, statement, connection);
        }
    }

    @Override
    public Pet getPetById(int petId) {
        connection = DbConnectionUtil.getConnection();
        String sql = "SELECT * FROM pet WHERE petId = ?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        Pet pet = null;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, petId);
            rs = statement.executeQuery();

            if (rs.next()) {
                pet = mapResultSetToPet(rs);
            } else {
                throw new PetNotFoundException("Pet with ID " + petId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, statement, connection);
        }

        return pet;
    }

    @Override
    public List<Pet> getAllPets() {
        connection = DbConnectionUtil.getConnection();
        String sql = "SELECT * FROM pet";
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Pet> petList = new ArrayList<>();

        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                Pet pet = mapResultSetToPet(rs);
                petList.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, statement, connection);
        }

        return petList;
    }

    private Pet mapResultSetToPet(ResultSet rs) throws SQLException {
        return new Pet(
                rs.getInt("pet_id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("type"),
                rs.getString("breed")
        );
    }

    private void closeResources(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) { e.printStackTrace(); }

        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) { e.printStackTrace(); }

        try {
            if (conn != null) conn.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
