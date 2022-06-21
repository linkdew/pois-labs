package org.linkdew.commands;

import org.linkdew.daopattern.entities.User;
import org.linkdew.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandLogin implements ICommand {
    private final static String AUTH_PAGE = "/login.jsp";
    private final static String MAIN_PAGE = "redirect:/main";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            return MAIN_PAGE;
        }

        if ("GET".equals(request.getMethod())) {
            return AUTH_PAGE;
        } else {
            String login = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println("login: " + login);
            System.out.println("password: " + password);

            if (login == null ||  password == null || login.isEmpty() || password.isEmpty()) {
                request.setAttribute("message", "there is no user with such username or password");
                return AUTH_PAGE;
            }

            User user = new UserService().login(login, password);

            if (user == null) {
                request.setAttribute("message", "there is no user with such username or password");
                return AUTH_PAGE;
            } else {
                request.getSession().setAttribute("user", user);
                return MAIN_PAGE;
            }
        }
    }
}
