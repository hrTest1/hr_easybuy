package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by canhe on 2016/7/6.
 */
public class EbProductDao extends BaseDao{
    //通过getProduct()读取数据库中网页相应商品信息存入List，并返回
    public List<EbProduct> getProduct(){

        List<EbProduct> productsList = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product order by ep_clickrate desc limit 0,10";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbProduct products = new EbProduct();
                products.setEp_description(rs.getString("ep_description"));
                products.setEp_id(rs.getInt("ep_id"));
                products.setEp_isdiscount(rs.getInt("ep_isdiscount"));
                products.setEp_clickrate(rs.getInt("ep_clickrate"));
                products.setEp_img(rs.getString("ep_img"));
                products.setEp_name(rs.getString("ep_name"));
                products.setEp_price(rs.getDouble("ep_price"));
                //添加到集合中
                productsList.add(products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsList;
    }
    public EbProduct getProductById(int id){
        EbProduct products = new EbProduct();

        List<String> params=new ArrayList<String>();
        String sql = "select * from easybuy_product where ep_id=?";
        params.add(id+"");
        try {
            ResultSet rs = this.executeSearch(sql,params);
            while (rs.next()){

                products.setEp_description(rs.getString("ep_description"));
                products.setEp_id(rs.getInt("ep_id"));
                products.setEp_isdiscount(rs.getInt("ep_isdiscount"));
                products.setEp_clickrate(rs.getInt("ep_clickrate"));
                products.setEp_img(rs.getString("ep_img"));
                products.setEp_name(rs.getString("ep_name"));
                products.setEp_price(rs.getDouble("ep_price"));
                //添加到集合中
              //  productsList.add(products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
