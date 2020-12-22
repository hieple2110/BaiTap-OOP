package com.codegym.hiep.controller;

import com.codegym.hiep.model.Miss;
import com.codegym.hiep.service.MissService;
import com.codegym.hiep.service.ProvinceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletApprovalMiss", urlPatterns = "/approvalMiss")
public class ServletApprovalMiss extends HttpServlet {
    MissService missService = new MissService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int passport = Integer.parseInt(request.getParameter("passport"));
        Miss miss = this.missService.selectById(passport);
        RequestDispatcher dispatcher;
        if (miss == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            if (miss.getStatus().equals("Pending")) {
                miss.setStatus("Pass");
            } else if (miss.getStatus().equals("Pass")) {
                miss.setStatus("Not Pass");
            } else if (miss.getStatus().equals("Not Pass")) {
                miss.setStatus("Pending");
            }
            try {
                response.sendRedirect("/listMiss");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
