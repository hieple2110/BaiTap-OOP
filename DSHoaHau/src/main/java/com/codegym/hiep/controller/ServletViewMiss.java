package com.codegym.hiep.controller;

import com.codegym.hiep.model.Miss;
import com.codegym.hiep.model.Province;
import com.codegym.hiep.service.MissService;
import com.codegym.hiep.service.ProvinceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletViewMiss", urlPatterns = "/viewMiss")
public class ServletViewMiss extends HttpServlet {
    MissService missService = new MissService();
    ProvinceService provinceService = new ProvinceService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int passport = Integer.parseInt(request.getParameter("passport"));
        Miss miss = this.missService.selectById(passport);
        List<Province> listProvince = this.provinceService.findAll();
        RequestDispatcher dispatcher;
        if (miss == null){
            dispatcher = request.getRequestDispatcher("error.jsp");
        }else {
            request.setAttribute("miss",miss);
            request.setAttribute("listProvince",listProvince);
            dispatcher = request.getRequestDispatcher("miss/view.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
