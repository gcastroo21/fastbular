package br.com.fastbular.servlet;

import br.com.fastbular.dao.UniDao;
import br.com.fastbular.model.Uni;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/create-uni")
public class CreateUniServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String uniId = req.getParameter("id");
        String uniName = req.getParameter("uni-name");

        Uni uni = new Uni(uniId, uniName);

        UniDao UniDao = new UniDao();

        if (uniId.isBlank()) {

            UniDao.createUni(uni);

        } else {

            UniDao.updateUni(uni);
        }

        resp.sendRedirect("/find-all-unis");

    }

}