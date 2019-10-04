package server.dtos;

import server.daos.UserDTO;
import server.exceptions.RecordNotFoundException;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO extends DAO {
    public UserDAO() {
        this.table = "[USER]";
    }

    public long create(UserDTO user) {
        String SQL = this.injectTableName("INSERT INTO %s (username, password) VALUES (?, ?)");
        long id = -1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            int affectedRows = preparedStatement.executeUpdate();
            id = this.getCreatedId(affectedRows, preparedStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }

    public UserDTO findByUsername(String username) throws RecordNotFoundException {
        String SQL = this.injectTableName("SELECT TOP 1 * FROM %s WHERE username=?");
        try {
//            System.out.println(username);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            return UserDTO.fromModel(rs);
        } catch (SQLException | NoSuchAlgorithmException e) {
            throw new RecordNotFoundException();
        }
    }

}
