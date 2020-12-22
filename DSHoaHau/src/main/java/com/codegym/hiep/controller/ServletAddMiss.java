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

@WebServlet(name = "ServletAddMiss", urlPatterns = "/addMiss")
public class ServletAddMiss extends HttpServlet {
    MissService missService = new MissService();
    ProvinceService provinceService = new ProvinceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String birth = request.getParameter("birthday");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int passport = Integer.parseInt(request.getParameter("passport"));
        String job = request.getParameter("job");
        String level = request.getParameter("level");
        String nation = request.getParameter("nation");
        String work = request.getParameter("workunit");
        float height = Float.parseFloat(request.getParameter("height"));
        float weight = Float.parseFloat(request.getParameter("weight"));
        String gifted = request.getParameter("gifted");
        String image = request.getParameter("image");
        String status = request.getParameter("status");
        String province = request.getParameter("province");

        if (!this.missService.checkMiss(passport, phone, email)) {
            this.missService.add(new Miss(name, birth, address, phone, email, passport, job,
                    level, nation, work, height, weight, gifted, image, status, province));
            request.setAttribute("message", "<script>\n" +
                    "    alert(\"Create new Miss\")\n" +
                    "</script>");
        } else {
            request.setAttribute("message", "<script>\n" +
                    "    alert(\"No create miss because miss duplicate email or phone or passport\")\n" +
                    "</script>");
        }
        try {
           response.sendRedirect("/listMiss");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        List<Province> listProvince = this.provinceService.findAll();
        request.setAttribute("listProvince", listProvince);
        RequestDispatcher dispatcher = request.getRequestDispatcher("miss/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
