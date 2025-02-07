package code;

import java.sql.SQLException;

public interface PaymentDAOInterface {
    void storePayment(Payment payment) throws SQLException;
}
