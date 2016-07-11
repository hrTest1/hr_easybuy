package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.*;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNotice;
import sdkd.com.ec.model.EbPCategory;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by canhe on 2016/7/10.
 */
@WebServlet(name = "BKproductController")
public class BKproductController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        EbNewsDao newsDao = new EbNewsDao();

        List<EbNews> newslist = newsDao.getNews();
        request.setAttribute("newList",newslist);

        EbNoticeDao noticeDao= new EbNoticeDao();
        List<EbNotice> noticelist=noticeDao.getNotice();
        request.setAttribute("noticeList",noticelist);

        EbPCategoryDao categoryDao = new EbPCategoryDao();
        List<EbPCategory> categorylist = categoryDao.getCategory();
        request.setAttribute("categoryList",categorylist);

        EbProductDao ProductDao = new EbProductDao();
        //通过getProduct()读取数据库中网页相应商品信息存入List，并返回
        List<EbProduct> productlist = ProductDao.getProduct();
        request.setAttribute("ProductList",productlist);

        request.setAttribute("user", EbUserDao.isLogin());
        //跳转
        request.getRequestDispatcher("manage/product.jsp").forward(request,response);
    }
}
