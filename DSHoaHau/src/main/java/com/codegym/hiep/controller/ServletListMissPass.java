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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletListMissPass", urlPatterns = "/listPass")
public class ServletListMissPass extends HttpServlet {
    MissService missService = new MissService();
    ProvinceService provinceService = new ProvinceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        List<Miss> listMiss = this.missService.findAll();
        List<Miss> listPass = new ArrayList<>();
        for (Miss item : listMiss){
            if (item.getStatus().equals("Pass")){
                listPass.add(item);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("miss/pass.jsp");
        try {
            request.setAttribute("listPass",listPass);
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
