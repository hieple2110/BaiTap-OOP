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

@WebServlet(name = "ServletEditMiss", urlPatterns = "/editMiss")
public class ServletEditMiss extends HttpServlet {
    MissService missService = new MissService();
    ProvinceService provinceService = new ProvinceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int passport = Integer.parseInt(request.getParameter("passport"));
        String name = request.getParameter("name");
        String birth = request.getParameter("birthday");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String job = request.getParameter("job");
        String level = request.getParameter("level");
        String nation = request.getParameter("nation");
        String work = request.getParameter("workunit");
        float height = Float.parseFloat(request.getParameter("height"));
        float weight = Float.parseFloat(request.getParameter("weight"));
        String gifted = request.getParameter("gifted");
        String image = request.getParameter("image");
        String province = request.getParameter("province");
        Miss miss = this.missService.selectById(passport);
        if (miss == null) {
           response.sendRedirect("/error");
        } else {
            miss.setName(name);
            miss.setBirthDay(birth);
            miss.setAddress(address);
            miss.setNumberPhone(phone);
            miss.setEmail(email);
            miss.setPassport(passport);
            miss.setJob(job);
            miss.setLevel(level);
            miss.setNation(nation);
            miss.setWorkUnit(work);
            miss.setHeight(height);
            miss.setWeight(weight);
            miss.setGifted(gifted);
            miss.setImage(image);
            miss.setProvince(province);
            this.missService.edit(passport,miss);
            request.setAttribute("miss",miss);
            response.sendRedirect("/listMiss");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        int passport = Integer.parseInt(request.getParameter("passport"));
        Miss miss = this.missService.selectById(passport);
        List<Province> listProvince = this.provinceService.findAll();
        RequestDispatcher dispatcher = null;
        if (miss == null) {
            response.sendRedirect("/error");
        } else {
            request.setAttribute("miss", miss);
            request.setAttribute("listProvince", listProvince);
           dispatcher = request.getRequestDispatcher("miss/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
}
