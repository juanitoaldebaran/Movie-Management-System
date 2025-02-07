package code;

import java.sql.*;

public class PaymentDAO implements PaymentDAOInterface{

        private Connection connection;

        public PaymentDAO(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void storePayment(Payment payment) throws SQLException {
            String query = "INSERT INTO payment_table (user_id, total_amount) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, payment.getUserID());
                stmt.setDouble(2, payment.getTotalAmount());
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int paymentId = rs.getInt(1);
                }
            }
        }

}
