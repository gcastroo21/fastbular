package br.com.fastbular.dao;

import java.sql.*;
import java.util.Scanner;

public class NotaDeCorteDAO {

    public void CompareNotaCorte(String nomeUni1,String nomeUni2) throws SQLException {
        // Criando um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário o nome das universidades
        System.out.println("Digite o nome da primeira universidade: ");
        nomeUni1 = scanner.nextLine();
        System.out.println("Digite o nome da segunda universidade: ");
        nomeUni2 = scanner.nextLine();

        // Conectando ao banco de dados
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

        // Criando a consulta SQL
        String sql = "SELECT * FROM uni WHERE nome = '" + nomeUni1 + "' OR nome = '" + nomeUni2 + "'";

        // Executando a consulta
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // Iterando sobre os resultados
        while (resultSet.next()) {
            // Obtendo as notas de corte
            float notaFaculdadeA = resultSet.getFloat("nota_de_corte");
            float notaFaculdadeB = resultSet.getFloat("nota_de_corte");

            // Comparando as notas
            String resultado = "";
            if (notaFaculdadeA > notaFaculdadeB) {
                resultado = "A Faculdade A tem nota de corte maior que a Faculdade B";
            } else if (notaFaculdadeA < notaFaculdadeB) {
                resultado = "A Faculdade B tem nota de corte maior que a Faculdade A";
            } else {
                resultado = "As faculdades têm a mesma nota de corte";
            }

            // Retornando as notas de corte e o resultado da comparação
            System.out.println("Nota de corte da Faculdade A: " + notaFaculdadeA);
            System.out.println("Nota de corte da Faculdade B: " + notaFaculdadeB);
            System.out.println("Resultado da comparação: " + resultado);
        }

        // Fechando a conexão com o banco de dados
        connection.close();
    }
}