package de.telran.g_240123_m_be_two_databases.repository.dog;

import de.telran.g_240123_m_be_two_databases.domain.entity.dog.Dog;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static de.telran.g_240123_m_be_two_databases.constants.Constants.ID;
import static de.telran.g_240123_m_be_two_databases.constants.Constants.NAME;
import static de.telran.g_240123_m_be_two_databases.domain.db.DogConnector.getConnection;

@Repository
public class DogRepository {

    public List<Dog> getAll() {
        try (Connection connection = getConnection()) {

            String query = "select * from dog;";
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            List<Dog> dogs = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String name = resultSet.getString(NAME);
                dogs.add(new Dog(id, name));
            }

            return dogs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}