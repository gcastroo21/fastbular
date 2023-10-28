package br.com.fastbular.dao;

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

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

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

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Uni> unis = new ArrayList<>();

            while (resultSet.next()) {

                String uniName = resultSet.getString("name");

                Uni uni = new Uni(uniName);

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

}