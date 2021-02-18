package com.example.Controller;

import com.example.DAO.CLientDAOImpl;
import com.example.Module.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.ref.Cleaner;
import java.util.List;

@WebServlet(name = "ClientServlet", value = "/Client")
public class ClientServlet extends HttpServlet {
    private CLientDAOImpl clientDI = new CLientDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewInfo(request, response);
                break;
            case "/insert":
                insertClient(request, response);
                break;
            case "/delete":
                deleteClient(request, response);
                break;
            case "/edit":
                showEditForm(request,response);
                break;
            case "/update":
                updateClient(request,response);
                break;
            default:
                listClient(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    private void showNewInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("client-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numeroCompte = request.getParameter("numero");
        String typeCompte = request.getParameter("type");
        String solde = request.getParameter("solde");

        clientDI.insertClient(1, numeroCompte, typeCompte, solde);
        response.sendRedirect("List");
    }


    private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        clientDI.deleteClient(id);
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Client client = clientDI.selectClient(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client-form.jsp");
        request.setAttribute("client", client);
        dispatcher.forward(request,response);

    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String numeroCompte = request.getParameter("numero");
        String typeCompte = request.getParameter("type");
        String solde = request.getParameter("solde");

        clientDI.updateClient(id, numeroCompte,typeCompte, solde);
        response.sendRedirect("list");
    }

    private void listClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clientList = clientDI.getAllClient();
        request.setAttribute("clientList", clientList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("client_list.jsp");
        dispatcher.forward(request, response);

    }
}