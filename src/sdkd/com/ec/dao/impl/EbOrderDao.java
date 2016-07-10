package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbOder;
import sdkd.com.ec.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdust on 2016/7/10.
 */
public class EbOrderDao extends BaseDao{

    public void saveorder(EbOder order)
    {
        String sql="insert easybuy_order(eo_user_id,eo_user_name,eo_user_address,eo_create_time,eo_cost,eo_status,eo_type) " +
                "values(?,?,?,?,?,?,?)";
        List<String> params=new ArrayList<String>();

        params.add(order.getEouserId());
        params.add(order.getEouserName());
        params.add(order.getEouserAddress());
        params.add(DateUtil.parseDateToStr(order.getEocreateTime(),"yyyy-MM-dd"));
        params.add(order.getEoCost()+"");
        params.add(order.getEoStatus()+"");
        params.add(order.getEoType()+"");
        this.exeucteModify(sql,params);
    }
}








