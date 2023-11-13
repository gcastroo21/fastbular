package br.com.fastbular.functions;

import java.sql.*;

public class CompareNotaDeCorte {

    public static void main(String[] args) throws SQLException {
        // Conectando ao banco de dados
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

        // Criando a consulta SQL
        String sql = "SELECT * FROM UNI WHERE nome = 'Faculdade A' OR nome = 'Faculdade B'";

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
