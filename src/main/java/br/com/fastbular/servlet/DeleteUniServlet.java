package br.com.fastbular.servlet;

import br.com.fastbular.dao.UniDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-uni")
public class DeleteUniServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String uniId = req.getParameter("id");
        new UniDao().deleteUniById(uniId);

        resp.sendRedirect("/find-all-uni");

    }

}