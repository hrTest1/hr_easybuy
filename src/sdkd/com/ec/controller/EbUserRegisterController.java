package sdkd.com.ec.controller;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
@WebServlet(name = "EbUserRegisterController")
public class EbUserRegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EbUser user=new EbUser();
        //处理中文乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String name=request.getParameter("userName");
        String password=request.getParameter("passWord");
        String rePassword=request.getParameter("rePassWord");
        if(name!=null && !"".equals(name) && password!=null && "".equals(password) && password.equals(rePassword)){
            user.setName(name);
            user.setPassword(password);
        }

        List<String> params = new ArrayList<String>();

        String sql="insert into easybuy_user(eu_user_name,eu_password) values(?,?)";
        params.add(0,name);
        params.add(1,password);
        new BaseDao().exeucteModify(sql,params);

        request.getRequestDispatcher("/reg-result.jsp").forward(request,response);

    }
}
