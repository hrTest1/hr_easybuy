package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbOderdetail;
import sdkd.com.ec.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdust on 2016/7/10.
 */
public class EbOrderdetailDao extends BaseDao {
    public void saveOrderDetail(EbOderdetail detail)
    {
        String sql="insert easybuy_order_detail(eo_id,ep_id,eod_quantity,eod_cost) " +
                "values(?,?,?,?)";
        List<String> params=new ArrayList<String>();

        params.add(detail.getEoId()+"");
        params.add(detail.getEpId()+"");
        params.add(detail.getEodQuantity()+"");
        params.add(detail.getEodCost()+"");

        this.exeucteModify(sql,params);
    }
}
