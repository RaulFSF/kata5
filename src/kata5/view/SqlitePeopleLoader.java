package kata5.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Person;

public class SqlitePeopleLoader implements PeopleLoader {
    
    @Override
    public List<Person> load(){
        try{
            List<Person> personas = new ArrayList<>();
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:data/bd.db");
            try(Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
                while(resultSet.next()){
                    String email = resultSet.getString("email");
                    if(isValidEmail(email)){
                        personas.add(new Person(resultSet.getString("first_name"),
                            resultSet.getString("address"), email));
                    }
                }         
            }
            return personas;
        } catch(ClassNotFoundException | SQLException ex){
            System.out.println("Erros en la lectura de la base de datos");
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    private boolean isValidEmail(String email){
        return email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^ `[|]~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
    }
    
}
