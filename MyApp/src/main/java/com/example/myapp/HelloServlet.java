package com.example.myapp;


import dao.inter.SkillDaoInter;
import dao.inter.UserDaoInter;
import entity.Skill;
import entity.User;
import main.Context;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MyApp", value = "/MyApp")
public class HelloServlet extends HttpServlet {

    private String message;
    //    private UserDaoInter userDaoInter= Context.instanceUserDao();
    private SkillDaoInter skillDaoInter = Context.instanceSkillDao();

    public void init() {
        message = "Hello World!";
    }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        List<Skill> list = skillDaoInter.getAll();
//        String name = String.valueOf(request.getParameter("name"));
//        int id = Integer.parseInt(request.getParameter("id"));
//        skillDaoInter.updateSkill(new Skill(id, name));
        out.println("<html><body>");
        for (Skill skill : list) {
            out.println(skill);
        }
        out.println("</body></html>");
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        List<Skill> list = skillDaoInter.getAll();
        Integer id=Integer.parseInt(request.getParameter("id"));
        String name = String.valueOf(request.getParameter("name"));
        skillDaoInter.updateSkill(new Skill(id, name));
        out.println("<html><body>");
        for(Skill skill:list){
            out.println(skill);
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}