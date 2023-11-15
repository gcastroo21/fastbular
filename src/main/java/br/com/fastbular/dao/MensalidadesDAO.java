package br.com.fastbular.dao;

import java.sql.*;
import java.util.Scanner;

public class MensalidadesDAO {

    public void CompareMensalidade(String nomeUni1,String nomeUni2,String curso) throws SQLException {
        // Conectando ao banco de dados
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

        // Lendo as entradas do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da primeira universidade: ");
        nomeUni1 = scanner.nextLine();
        System.out.println("Digite o nome da segunda universidade: ");
        nomeUni2 = scanner.nextLine();
        System.out.println("Digite o nome do curso: ");
        curso = scanner.nextLine();

        // Selecionando as mensalidades das faculdades
        String sql = "SELECT mensalidade FROM uni WHERE nome = ? AND curso = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nomeUni1);
        preparedStatement.setString(2, curso);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Obtendo a mensalidade da primeira faculdade
        float mensalidadeFaculdadeX = 0.0f;
        if (resultSet.next()) {
            mensalidadeFaculdadeX = resultSet.getFloat("mensalidade");
        }

        // Selecionando as mensalidades das faculdades
        sql = "SELECT mensalidade FROM uni WHERE nome = ? AND curso = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nomeUni2);
        preparedStatement.setString(2, curso);
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