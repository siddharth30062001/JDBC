package com.jdbcexample;

import java.sql.SQLException;

public class DataBaseConnectivity {

    public DataBaseConnectivity() {
    }

    public static void main(String[] args) throws SQLException {
        JDBCExample jdbcExample = new JDBCExample();
        // jdbcExample.getConnection();
        // jdbcExample.createTable();
        // jdbcExample.insertData(new Employee(105, "Tom", 25));
        // jdbcExample.insertData(new Employee(106, "Jerry", 20));
        jdbcExample.readData();


    }

}

