package br.com.fastbular.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class NotaMEC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conexao = null;
        try {
            // Conecta ao banco de dados
            conexao = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            // Solicita a universidade ao usuário
            System.out.println("Informe o nome da universidade:");
            String nomeUni = scanner.nextLine();

            // Monta a consulta SQL
            String sql = "SELECT nota_do_mec FROM uni WHERE nome = ?";

            // Prepara a consulta
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nomeUni);

            // Executa a consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verifica se a consulta retornou alguma linha
            if (resultSet.next()) {
                // Exibe a nota do MEC
                System.out.println("A nota do MEC da universidade " + nomeUni + " é " + resultSet.getFloat("nota_do_mec"));
            } else {
                // A universidade não foi encontrada
                System.out.println("A universidade " + nomeUni + " não foi encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fecha a conexão com o banco de dados
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
