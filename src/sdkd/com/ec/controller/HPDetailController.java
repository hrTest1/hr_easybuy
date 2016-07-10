package sdkd.com.ec.controller;
import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by canhe on 2016/7/7.
 */
@WebServlet(name = "HPDetailController")
public class HPDetailController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        //点击量+1
        String ep_clickrate = request.getParameter("ep_clickrate");
        int clickrate = Integer.parseInt(ep_clickrate);
        clickrate = clickrate + 1;
        //更新对应数据库
        String ep_id = request.getParameter("ep_id");
        String sql = "update easybuy_product set ep_clickrate=? where ep_id=?";
        List<String> params = new ArrayList<String>();
        params.add(0, String.valueOf(clickrate));
        params.add(1, ep_id);
        new BaseDao().exeucteModify(sql, params);

        //页面详情
        //从数据库读取相应名字
        String sqlname = "select ep_name from easybuy_product where ep_id=?";
        List<String> params1 = new ArrayList<String>();
        params1.add(ep_id);
        ResultSet nameresult = new BaseDao().executeSearch(sqlname, params1);
        String name = null;
        try {
            while (nameresult.next()) {
                name = nameresult.getString("ep_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //从数据库读取相应价格
        String sqlprice = "select ep_price from easybuy_product where ep_id=?";
        ResultSet priceresult = new BaseDao().executeSearch(sqlprice,params1);
        String price = null;
        try {
            while(priceresult.next()){
                price = priceresult.getString("ep_price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //从数据库读取ep_desciption
        String desql = "select ep_description from easybuy_product where ep_id=?";
        ResultSet deresult = new BaseDao().executeSearch(desql,params1);
        String des = null;
        try {
            while (deresult.next()){
                des = deresult.getString("ep_description");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //从数据库读取ep_img
        String sqlimg = "select ep_img from easybuy_product where ep_id=?";
        ResultSet imgresult = new BaseDao().executeSearch(sqlimg,params1);
        String img = null;
        try {
            while(imgresult.next()){
                img = imgresult.getString("ep_img");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //从数据库读取ep_stock
        String sqlstock = "select ep_stock from easybuy_product where ep_id=?";
        ResultSet stockresult = new BaseDao().executeSearch(sqlstock,params1);
        String stock = null;
        try {
            while(stockresult.next()){
                stock = stockresult.getString("ep_stock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //将从数据库读取的商品详情传给product-view.jsp
        request.setAttribute("id",ep_id);
        request.setAttribute("name", name);
        request.setAttribute("price",price);
        request.setAttribute("des",des);
        request.setAttribute("img",img);
        request.setAttribute("stock",stock);
        request.setAttribute("user", EbUserDao.isLogin());
        request.getRequestDispatcher("product-view.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
