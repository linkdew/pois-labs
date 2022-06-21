package org.linkdew.controller;

import org.linkdew.commands.CommandLogin;
import org.linkdew.commands.ICommand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Controller", value = "/")
public class Controller extends HttpServlet {
    ControllerHelper controllerHelper = ControllerHelper.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private Boolean isAuth(HttpServletRequest request){
        return request.getSession().getAttribute("user") != null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;

        if (!isAuth(request)) {
            page = new CommandLogin().execute(request, response);
        }
        else {
            ICommand command = controllerHelper.getCommand(request);
            page = command.execute(request, response);
        }

        System.out.println("NEXT PAGE: " + page);
        if (page.startsWith("redirect:")) {
            response.sendRedirect(page.substring(9));
            return;
        }

        request.getRequestDispatcher(page).forward(request, response);
    }
}
