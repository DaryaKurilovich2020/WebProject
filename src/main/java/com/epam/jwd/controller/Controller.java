package com.epam.jwd.controller;

import com.epam.jwd.controller.command.Command;
import com.epam.jwd.controller.command.CommandProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {
    private final CommandProvider provider = new CommandProvider();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      process(request, response);


    }
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name;
        Command command;

        name = request.getParameter("command");
        command = provider.takeCommand(name);
        command.execute(request, response);
    }

}
