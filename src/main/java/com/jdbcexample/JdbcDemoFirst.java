package com.jdbcexample;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.management.RuntimeErrorException;

public class JdbcDemoFirst {

    public JdbcDemoFirst() {
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/employee";
        String user = "root";
        String password = "rajput@2001";
        return DriverManager.getConnection(url, user, password);
    }

    public void createTable() {

        String sqlQuery = "create table employees(id int primary key,name varchar(50),age int)";

        try (
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(sqlQuery);
            System.out.println("Table created Successfully");
            }
           catch(SQLException e){
              throw new RuntimeException(e);
           }

    }

    public void insertData(Employee e) throws SQLException{

            String query="insert into employees values(?,?,?)";
            try(
            Connection connection = this.getConnection();
            PreparedStatement ps=connection.prepareStatement(query)){
            ps.setInt(1,e.getId());
            ps.setString(2,e.getName());
            ps.setInt(3, e.getAge());
            ps.executeUpdate();
            System.out.println("Data inserted sucessfully!!");
            }
            catch(SQLException ex){
                throw new RuntimeException(ex);
            }
            
            


    }

    public void readData(){

        List<Employee> employeesList=new ArrayList<>();
        String query="select * from employees";

        try(
            Connection connection=this.getConnection();
            Statement statement=connection.createStatement();
            ResultSet result=statement.executeQuery(query)){
            while (result.next()) {

                int id=result.getInt("id");
                String name=result.getString("name");
                int age=result.getInt("age");
                Employee e=new Employee(id, name, age);
                employeesList.add(e);

                System.out.println("ID: "+id +" name: "+name+" age: "+age);
                
            }

        }
        catch(Throwable e){
            e.printStackTrace();
        }
    }

    public void update(int id,String name,int age){

        String query="update employees set name=?,age=? where id=?";
        try(
            Connection connection=this.getConnection();
            PreparedStatement ps=connection.prepareStatement(query)){
                ps.setString(1,name);
                ps.setInt(2,age );
                ps.setInt(3,id );
                ps.executeUpdate();
                System.out.println("Data Update Sucessfully"); 
                
                
    }
    catch(Throwable e){
        e.printStackTrace();
    }

    
}

    }
