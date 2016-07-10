package sdkd.com.ec.controller;

import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.EbUser;
import sdkd.com.ec.model.ShoppingCart;
import sdkd.com.ec.model.ShoppingCartItem;
import sdkd.com.ec.service.EbOrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by sdust on 2016/7/8.
 */
@WebServlet(name = "EbShoppingController")
public class EbShoppingController extends HttpServlet {
    EbProductDao productDao=new EbProductDao();
    EbOrderService orderService=new EbOrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        if(EbUserDao.isLogin()==false){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else if(EbUserDao.isLogin()==true){

            String action=request.getParameter("action");
            if("mod".equals(action)){
                modifyCart(request, response);
            }else if("remove".equals(action)){
                removeCart(request, response);
            }else if("moveall".equals(action))
            {
                List<ShoppingCartItem> itemsclear=new ArrayList<ShoppingCartItem>();
                cart.setItems(itemsclear);
                request.getSession().setAttribute("totalcost",0);
            }else if("pay".equals(action))
            {
                PayCart(request,response);
            }
            else {
                //存储到Session
                String paramsId=request.getParameter("id");
                int id=0;
                boolean issame=false;
                if(paramsId!=null && !"".equals(paramsId))
                {
                    id=Integer.parseInt(paramsId);
                }
                EbProduct product=productDao.getProductById(id);



                if (cart == null) {
                    cart = new ShoppingCart();
                    cart.addItem(product,1);
                } else {
                    //如果存在，查找有无相同商品，如果有则更新数量
                    List<ShoppingCartItem> items = cart.getItems();
                    if (items != null && items.size() > 0) {
                        for (ShoppingCartItem item : items) {
                            EbProduct itemPro = item.getProduct();
                            if (itemPro.getEp_id() == id) {
                                item.setQuantity(item.getQuantity() + 1);
                                issame = true;
                            }
                        }

                    }
                    if (!issame) {
                        cart.addItem(product, 1);
                    }

                }
                request.getSession().setAttribute("cart", cart);
                request.getSession().setAttribute("totalcost",cart.getTotalCost());
            }

            response.sendRedirect("/shopping.jsp");
        }
    }

    public void modifyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        long quantity = 0;
        int index = 0;
        String quantityParam = request.getParameter("quantity");
        String indexParam = request.getParameter("index");
        if(quantityParam!=null && !"".equals(quantityParam)){
            quantity = Long.valueOf(quantityParam);
        }
        if(indexParam!=null && !"".equals(indexParam)){
            index = Integer.valueOf(indexParam);
        }
        cart.modifyQuantity(index,quantity);
        request.getSession().setAttribute("totalcost",cart.getTotalCost());
    }

    public void removeCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
        int index = 0;
        String indexParam = request.getParameter("index");
        if(indexParam!=null && !"".equals(indexParam)){
            index = Integer.valueOf(indexParam);
        }
        cart.removeItem(index);
        request.getSession().setAttribute("totalcost",cart.getTotalCost());
    }
    public void PayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("cart");
        EbUser user=(EbUser)request.getSession().getAttribute("ebuser");
        if(cart!=null)
        {
            orderService.payOrder(cart,user);
        }

    }
}
