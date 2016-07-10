package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbPCategoryDao;
import sdkd.com.ec.model.EbPCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sdust on 2016/7/7.
 */
@WebServlet(name = "EbPCategoryController")
public class EbPCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //跳转
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
