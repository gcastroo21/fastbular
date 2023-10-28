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

@WebServlet("/find-all-unis")
public class ListUniServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Uni> unis = new UniDao().findAllUnis();

        req.setAttribute("unis", unis);

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

    }

}