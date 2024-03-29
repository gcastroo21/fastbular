package br.com.fastbular.dao;

import br.com.fastbular.config.ConnectionPoolConfig;
import br.com.fastbular.model.Uni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniDao
{


     public void createUni(Uni uni)   {
        String SQL = "INSERT INTO UNI (NAME) VALUES (?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, uni.getName());
            preparedStatement.execute();

            System.out.println("success in insert uni");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }

    public List<Uni> findAllUnis() {

        String SQL = "SELECT * FROM UNI";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Uni> unis = new ArrayList<>();

            while (resultSet.next()) {

                String uniId = resultSet.getString("id");
                String uniName = resultSet.getString("name");

                Uni uni = new Uni(uniId, uniName);

                unis.add(uni);

            }

            System.out.println("success in select * uni");

            connection.close();

            return unis;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();

        }

    }
    public void deleteUniById(String uniId){
         String SQL = "DELETE UNI WHERE ID= ?";
        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, uniId);
            preparedStatement.execute();

            System.out.println("success on delete uni with id: " + uniId);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }
    }
    public void updateUni(Uni Uni) {

        String SQL = "UPDATE UNI SET NAME = ? WHERE ID = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            
            
            preparedStatement.setString(1, Uni.getName());
            preparedStatement.setString(2, Uni.getId());
            preparedStatement.execute();

            System.out.println("success in update uni");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");
            System.out.println("Error: " + e.getMessage());

        }

    }

}