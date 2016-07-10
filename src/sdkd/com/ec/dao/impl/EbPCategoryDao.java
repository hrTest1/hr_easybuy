package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbPCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdust on 2016/7/7.
 */
public class EbPCategoryDao extends BaseDao {
    public List<EbPCategory> getCategory() {
        List<EbPCategory> categoryList = new ArrayList<EbPCategory>();
        String sql = "select * from easybuy_product_category";
        try {
            ResultSet rs = this.executeSearch(sql, null);
            while (rs.next()) {
                EbPCategory category = new EbPCategory();
                category.setEpcId(rs.getInt("epc_id"));
                category.setEpcName(rs.getString("epc_name"));
                category.setEpcParentId(rs.getInt("epc_parent_id"));
                //添加到集合中
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
