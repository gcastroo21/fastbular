package br.com.fastbular.dao;

import br.com.fastbular.model.Uni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UniDao
{

    public void createUni(Uni uni)
    {
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

}