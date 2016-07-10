package sdkd.com.ec.controller;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */

public class EbUserLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理中文乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        EbUserDao user=new EbUserDao();

        String name=request.getParameter("userName");
        String password=request.getParameter("passWord");
        EbUser ebUser=new EbUser();

        if(name!=null && !"".equals(name) && password!=null && !"".equals(password)){
            ebUser.setName(name);
            ebUser.setPassword(password);
            List<String> params = new ArrayList<String>();
            String sql="select * from easybuy_user where eu_user_name=? and eu_password=?";
            params.add(name);
            params.add(password);
            ResultSet rs = new BaseDao().executeSearch(sql,params);
            try {
                    if (rs.next()){
                        int id =rs.getInt("eu_user_id");

                        String username=rs.getString("eu_user_name");
                        String psw=rs.getString("eu_password");
                        String addr = rs.getString("eu_address");
                        ebUser.setId(id);
                        ebUser.setAddress(addr);
                        if(name.equals(username) && password.equals(psw)){
                            user.setLoginState(true);
                        }
                     }
                    if(user.isLogin()==true){
                        request.getSession().setAttribute("ebuser",ebUser);
                        request.setAttribute("user",user);
                        request.getRequestDispatcher("/index.do").forward(request,response);
                    }
                    else{
                        request.getRequestDispatcher("/test.jsp").forward(request,response);
                    }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
