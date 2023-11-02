package de.telran.g_240123_m_be_two_databases.repository.cat;

import de.telran.g_240123_m_be_two_databases.domain.entity.cat.Cat;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static de.telran.g_240123_m_be_two_databases.constants.Constants.ID;
import static de.telran.g_240123_m_be_two_databases.constants.Constants.NAME;
import static de.telran.g_240123_m_be_two_databases.domain.db.CatConnector.getConnection;

@Repository
public class CatRepository {

    public List<Cat> getAll() {
        try (Connection connection = getConnection()) {

            String query = "select * from cat;";
            ResultSet resultSet = connection.createStatement().executeQuery(query);
            List<Cat> cats = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String name = resultSet.getString(NAME);
                cats.add(new Cat(id, name));
            }

            return cats;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}