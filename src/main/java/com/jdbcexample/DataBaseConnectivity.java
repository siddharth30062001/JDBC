package com.jdbcexample;

import java.sql.SQLException;

public class DataBaseConnectivity {

    public DataBaseConnectivity() {
    }

    public static void main(String[] args) throws SQLException {
        JdbcDemoFirst jdbcExample = new JdbcDemoFirst();
        // jdbcExample.getConnection();
        // jdbcExample.createTable();
        // jdbcExample.insertData(new Employee(105, "Tom", 25));
        //jdbcExample.insertData(new Employee(107, "Jhon", 20));
        jdbcExample.readData();
        //jdbcExample.update(107,"Raj",30);
       


    }

}

