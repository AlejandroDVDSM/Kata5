package kata5.view;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Mail;

public class MailDatabaseReader {

    public static List<Mail> read() throws SQLException, ClassNotFoundException {
        List<Mail> list = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data/usr500.db");
                Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT email FROM people");
     
            while (result.next()) {
                String email = result.getString("email");
                if (email == null) break;
                if(Mail.isMail(email)) {
                    list.add(new Mail(email));
                }
                System.out.println(email);
            }
        }
        
        return list;
    }
}