package br.com.fastbular.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create-uni")
public class CreateUniServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uniName = request.getParameter("uni-name");

        System.out.println(uniName);

        request.getRequestDispatcher("index.html").forward(request, response);

    }

}