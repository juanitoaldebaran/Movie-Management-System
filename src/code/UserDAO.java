package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserDAOInterface<User>{

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/movie_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aldebaran1711";

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public void insertUser(User user) throws SQLException {
            String insertQuery = "INSERT INTO user_table (user_id, username, password, email, user_type) VALUES (?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                statement.setInt(1, user.getUserID());
                statement.setString(2, user.getUserName());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getEmail());
                statement.setString(5, String.valueOf(user.getEmail()));
            }
    }

    @Override
    public List<User> listUser() throws SQLException {
        String listUser = "SELECT * FROM user_table";
        List<User> userList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(listUser)) {
            try (ResultSet rs = statement.executeQuery()){
                while (rs.next()) {
                    UserType userType = UserType.valueOf(rs.getString("user_type"));
                    if (userType == UserType.REGULER) {
                        Reguler userReguler = new Reguler(
                                rs.getInt("user_id"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("email")
                        );
                        userList.add(userReguler);
                    } else if (userType == UserType.PREMIUM) {
                        Premium userPremium = new Premium(
                                rs.getInt("user_id"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("email")
                        );
                        userList.add(userPremium);
                    }
                }
            }
        }

        return userList;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String updateUserQuery = "UPDATE user_table SET user_name = ?, password = ?, email = ?, user_type = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateUserQuery)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, String.valueOf(user.getUserType()));
            statement.setInt(5, user.getUserID());

            statement.executeUpdate();
        }
    }

    @Override
    public void deleteUser(int ID) throws SQLException {
        String deleteUserQuery = "DELETE FROM user_table WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteUserQuery)) {
            statement.setInt(1, ID);

            statement.executeUpdate();
        }
    }
}
