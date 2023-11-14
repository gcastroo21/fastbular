package br.com.fastbular.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustoBeneficio {

    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");

        // Consulta todas as universidades
        PreparedStatement consulta = conexao.prepareStatement("SELECT * FROM uni");
        ResultSet resultados = consulta.executeQuery();

        while (resultados.next()) {
            // Obtém os dados da universidade
            String nome = resultados.getString("nome");
            String curso = resultados.getString("curso");
            String cidade = resultados.getString("cidade");
            float notaDeCorte = resultados.getFloat("nota_de_corte");
            float mensalidade = resultados.getFloat("mensalidade");
            float notaDoMEC = resultados.getFloat("nota_do_mec");

            // Calcula o custo benefício
            float custoBeneficio = calcularCustoBeneficio(notaDoMEC, mensalidade);

            // Imprime os resultados
            System.out.println("Nome: " + nome);
            System.out.println("Curso: " + curso);
            System.out.println("Cidade: " + cidade);
            System.out.println("Nota de corte: " + notaDeCorte);
            System.out.println("Mensalidade: " + mensalidade);
            System.out.println("Custo benefício: " + custoBeneficio);
        }

        conexao.close();
    }

    private static float calcularCustoBeneficio(float notaDoMEC, float mensalidade) {
        // Calcula a nota média
        float notaMedia = (notaDoMEC + mensalidade) / 2;

        // Calcula o custo benefício
        float custoBeneficio = (notaMedia - 5) / 5;

        // Limita o custo benefício a 10
        if (custoBeneficio > 10) {
            custoBeneficio = 10;
        }

        return custoBeneficio;
    }
}