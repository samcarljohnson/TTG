package com.scjohnson.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddDataService {
  
  /**
   * uniqueStr(str) - Queries the database and checks to see if the user login is unique. 
   *   This is done via email.
   * @param email The user email to check for uniqueness.
   */
  public boolean uniqueStr(String str) {
    Connection con = DBConnect();
    try {
      //String query = "SELECT COUNT(*) FROM user_logins WHERE email='"+str+"';";
      String query = "SELECT COUNT(*) FROM user_data WHERE bubble_name='"+str+"';";
      Statement st = (Statement) con.createStatement();
      ResultSet rs = st.executeQuery(query);
      
      rs.next();
      String result = rs.getString(1);
      if(result.equals("0")) {
        st.close();    
        return true;
      }
      st.close();
      return false;
    } 
    catch(Exception ex) {
      System.out.println("Caught in uniqueUser");
      ex.printStackTrace();
    }
    return true;
  }
  
  /**
   * addData(a, b, c, d, e, f, g, h, i) - Adds the user's data to the user_data table in the db.
   * @param a bubble_name
   * @param b creator
   * @param c bubble_num_moments
   * @param d widget_nbu_views
   * @param e total_video_views
   * @param f visits
   * @param g views_per_visits
   * @param h average_watch_time
   * @param i percentage_mobile
   */
  public void addData(String a, String b, Integer c, Integer d, 
      Integer e, Integer f, Integer g, Integer h, Integer i) {
    Connection con = DBConnect();
    try {
      String query = "INSERT into user_data (bubble_name, creator, bubble_num_moments, widget_nbu_views,"
          + " total_video_views, visits, views_per_visit, average_watch_time, percentage_mobile) "
          + "VALUES ('"+a+"','"+b+"',"+c+","+d+
          ","+e+","+f+","+g+","+h+","+i+");";
      Statement st = (Statement) con.createStatement();
      st.executeUpdate(query);
      st.close();
    } 
    

    /*
    try {
      String query="insert into user_data(bubble_name, creator, bubble_num_moments, widget_nbu_views,"
          + " total_video_views, visits, views_per_visit, average_watch_time, percentage_mobile)"
          + " values (?,?)";
      PreparedStatement statement= con.prepareStatement(query);
      statement.setString(1,a);
      statement.setString(2,b);
      statement.setInt(3,c);
      statement.setInt(4,d);
      statement.setInt(5,e);
      statement.setInt(6,f);
      statement.setInt(7,g);
      statement.setInt(8,h);
      statement.setInt(9,i);;
      statement.executeUpdate();
      statement.close();
    }*/
    catch(Exception ex) {
      System.out.println("Caught in addData");
      ex.printStackTrace();
    }
  }
  
  public boolean getReport() {
    Connection con = DBConnect();
    try {
      //String query = "SELECT COUNT(*) FROM user_logins WHERE email='"+str+"';";
      String query = "SELECT COUNT(*) FROM user_data WHERE bubble_name='sam';";
      Statement st = (Statement) con.createStatement();
      ResultSet rs = st.executeQuery(query);
      
      rs.next();
      String result = rs.getString(1);
      if(result.equals("0")) {
        st.close();    
        return true;
      }
      st.close();
      return false;
    } 
    catch(Exception ex) {
      System.out.println("Caught in uniqueUser");
      ex.printStackTrace();
    }
    return true;
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
      } catch (Exception ex) {
          System.out.println("Caught in DBConnect");
          ex.printStackTrace();
      }
      return con;
  }
  
  

}
