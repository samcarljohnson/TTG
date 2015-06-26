package com.scjohnson.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginService {

  /**
   * uniqueUser(email) - Queries the database and checks to see if the user login is unique. 
   *   This is done via email.
   * @param email The user email to check for uniqueness.
   */
  public boolean uniqueUser(String email) {
    Connection con = DBConnect();
    try {
      String query = "SELECT COUNT(*) FROM user_logins WHERE email='"+email+"';";
      Statement st = (Statement) con.createStatement();
      ResultSet rs = st.executeQuery(query);
      if(rs.next()) {
        st.close();    
        return false;
      } else {
        st.close();
      }
    } 
    catch(Exception e) {
      System.out.println("Caught in uniqueUser");
      e.printStackTrace();
    }
    return true;
  }
  
  /**
   * registerUser(username, email, password) - Adds the user's information to the user-logins table in the db.
   * @param username User's username.
   * @param email User's email address.
   * @param password User's password.
   */
  public void registerUser(String username, String email, String password) {
    Connection con = DBConnect();
    try {
      String query = "INSERT into user_logins (name, email, password) "
          + "VALUES ('"+username+"','"+email+"','"+password+"');";
      Statement st = (Statement) con.createStatement();
      st.executeUpdate(query);
      st.close();
    } 
    catch(Exception e) {
      System.out.println("Caught in registerUser");
      e.printStackTrace();
    }
  }
  
  /**
   * DBConnect() - simply connect to the database.
   * @return Connection object to the database.
   */
  public Connection DBConnect() {
    String db = "postgres";
    String url = "jdbc:postgresql:";
    String driver = "org.postgresql.Driver";
    String user = "postgres";
    String password = "sam123";
    Connection con = null;
      try {
        Class.forName(driver);
        con = (Connection) DriverManager.getConnection(url + db, user, password);
        if (con == null) {
          System.out.println("Connection cannot be established");
          System.exit(0);
        }
      } catch (Exception e) {
          System.out.println("Caught in DBConnect");
          e.printStackTrace();
      }
      return con;
  }
  
  
  
  
}
