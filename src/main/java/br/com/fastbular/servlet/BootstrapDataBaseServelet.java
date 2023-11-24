package br.com.fastbular.servlet;

import org.h2.tools.RunScript;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(loadOnStartup = 1, urlPatterns = "/database")
public class BootstrapDataBaseServelet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        try {
            execute();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void execute() throws FileNotFoundException {

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            RunScript.execute(connection, new FileReader("src/main/resources/db.sql"));

            System.out.println("Sucess on load database tables");

        } catch (Exception e){
            System.out.println("failed on load database tables Cause: " + e.getMessage());
        }
    }


}
