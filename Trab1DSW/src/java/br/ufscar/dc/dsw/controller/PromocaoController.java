package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.model.Promocao;
import br.ufscar.dc.dsw.dao.PromocaoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns = {"/promocao/*"})


public class PromocaoController extends HttpServlet {

    private PromocaoDAO dao;

    @Override
    public void init() {
        dao = new PromocaoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf('/'));

        try {
            switch (action) {
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Promocao> listaPromocao = dao.getAll();
        request.setAttribute("listaPromocao", listaPromocao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/promocao_template/lista.jsp");
        dispatcher.forward(request, response);
    }
    
}