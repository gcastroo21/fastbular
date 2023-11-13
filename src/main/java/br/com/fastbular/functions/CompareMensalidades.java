package br.com.fastbular.functions;

import java.sql.*;

public class CompareMensalidades {

    public static void main(String[] args) throws SQLException {
        // Conectando ao banco de dados
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

        // Selecionando as mensalidades das faculdades
        String sql = "SELECT mensalidade FROM uni WHERE nome = ? AND curso = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "Faculdade X");
        preparedStatement.setString(2, "Engenharia da Computação");
        ResultSet resultSet = preparedStatement.executeQuery();

        // Obtendo a mensalidade da primeira faculdade
        float mensalidadeFaculdadeX = 0.0f;
        if (resultSet.next()) {
            mensalidadeFaculdadeX = resultSet.getFloat("mensalidade");
        }

        // Selecionando as mensalidades das faculdades
        sql = "SELECT mensalidade FROM uni WHERE nome = ? AND curso = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "Faculdade Y");
        preparedStatement.setString(2, "Engenharia da Computação");
        resultSet = preparedStatement.executeQuery();

        // Obtendo a mensalidade da segunda faculdade
        float mensalidadeFaculdadeY = 0.0f;
        if (resultSet.next()) {
            mensalidadeFaculdadeY = resultSet.getFloat("mensalidade");
        }

        // Fechando a conexão com o banco de dados
        connection.close();

        // Comparando as mensalidades
        if (mensalidadeFaculdadeX < mensalidadeFaculdadeY) {
            System.out.println("A mensalidade da Faculdade X é menor que a da Faculdade Y.");
        } else if (mensalidadeFaculdadeX > mensalidadeFaculdadeY) {
            System.out.println("A mensalidade da Faculdade X é maior que a da Faculdade Y.");
        } else {
            System.out.println("As mensalidades das duas faculdades são iguais.");
        }
    }
}