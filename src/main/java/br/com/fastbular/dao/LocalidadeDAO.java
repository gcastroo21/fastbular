package br.com.fastbular.dao;

import java.sql.*;
import java.util.*;
public class LocalidadeDAO {

    public void FiltrarLocal(String localidade) throws SQLException {
        // Conectar ao banco de dados
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

        // Obter a localidade desejada do usuário
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a localidade desejada: ");
        localidade = scanner.nextLine();

        // Criar um PreparedStatement para consultar o banco de dados
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM uni WHERE cidade = ?");
        statement.setString(1, localidade);

        // Executar a consulta
        ResultSet results = statement.executeQuery();

        // Imprimir as universidades encontradas
        while (results.next()) {
            System.out.println("Nome: " + results.getString("nome"));
            System.out.println("Curso: " + results.getString("curso"));
            System.out.println("Cidade: " + results.getString("cidade"));
            System.out.println("Nota de corte: " + results.getFloat("nota_de_corte"));
            System.out.println("Mensalidade: " + results.getFloat("mensalidade"));
            System.out.println("Nota do MEC: " + results.getFloat("nota_do_mec"));
            System.out.println();
        }

        // Fechar a conexão com o banco de dados
        connection.close();
    }
}