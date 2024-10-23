package com.jdbcexample;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JDBCExample {

    public JDBCExample() {
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/employee";
        String user = "root";
        String password = "rajput@2001";
        return DriverManager.getConnection(url, user, password);
    }

    public void createTable() {

        String sqlQuery = "create table employees(id int primary key,name varchar(50),age int)";

        try {
            Connection connection = this.getConnection();

            try {
                Statement statement = connection.createStatement();

                try {
                    statement.executeUpdate(sqlQuery);
                    System.out.println("Table created Successfully");
                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }

    }

    public void insertData(Employee e) throws SQLException{

            Scanner sc=new Scanner(System.in);
            Connection connection = this.getConnection();
            String query="insert into employees values(?,?,?)";

            PreparedStatement ps=connection.prepareStatement(query);
        
            ps.setInt(1,e.getId());
            ps.setString(2,e.getName());
            ps.setInt(3, e.getAge());
            ps.executeUpdate();
            System.out.println("Data inserted sucessfully!!");
            
            connection.close();


    }

    public void readData(){

        List<Employee> employeesList=new ArrayList<>();
        String query="select * from employees";

        try{
           
            Connection connection=this.getConnection();

            Statement statement=connection.createStatement();

            ResultSet result=statement.executeQuery(query);

            while (result.next()) {

                int id=result.getInt("id");
                String name=result.getString("name");
                int age=result.getInt("age");
                Employee e=new Employee(id, name, age);
                employeesList.add(e);

                System.out.println("ID: "+id +" name: "+name+" age: "+age);
                connection.close();
                
            }

        }

        catch(Throwable e){
            e.printStackTrace();
        }
    }



}
