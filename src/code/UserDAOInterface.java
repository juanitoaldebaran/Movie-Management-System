package code;

import java.sql.SQLException;
import java.util.List;

public interface UserDAOInterface<T>{

    void insertUser(User user) throws SQLException;

    List<User> listUser() throws SQLException;

    void updateUser(User user) throws SQLException;
    void deleteUser(int ID) throws SQLException;
}
