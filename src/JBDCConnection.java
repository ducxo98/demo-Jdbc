import java.sql.*;

public class JBDCConnection {
    public static Connection getConnection(){
        final String url = "jdbc:mysql://localhost:3306/demo";
        final String user = "root";
        final String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("thanh cong");
            String sql = "INSERT INTO PEOPLE(name) VALUES (?); ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

//            preparedStatement.setString(1, "kkk");
            preparedStatement.setString(1, "aaa");
            preparedStatement.addBatch();
            preparedStatement.setString(1, "fff");
            preparedStatement.addBatch();
            preparedStatement.executeBatch();

//            preparedStatement.setString(1, "fffff");

//            Statement statement = connection.createStatement();
//            preparedStatement.execute();
//            ResultSet resultSet = preparedStatement.execute(sql);
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + resultSet.getString("name"));
//
//        }
        } else {
            System.out.println("that bai");
        }
    }

}
