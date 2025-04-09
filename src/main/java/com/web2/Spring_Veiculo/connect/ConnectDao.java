package com.web2.Spring_Veiculo.connect;


import com.web2.Spring_Veiculo.model.dao.ErrorDao;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDao {

    private static final String URL = "jdbc:postgresql://localhost:5432/concesionaria";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Icsa@123";

    public static Connection dataSource() throws ErrorDao{
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (Exception e){
            throw new ErrorDao(e);
        }
    }


}
