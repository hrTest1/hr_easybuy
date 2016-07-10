package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNotice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdust on 2016/7/6.
 */
public class EbNoticeDao extends BaseDao {
    public List<EbNotice> getNotice(){
        List<EbNotice> noticeList = new ArrayList<EbNotice>();
        String sql = "select * from easybuy_notice order by en_notice_time desc";
        try {
            ResultSet rs = this.executeSearch(sql,null);
            while (rs.next()){
                EbNotice notices=new EbNotice();
                notices.setNoticeId(rs.getInt("en_notice_id"));
                notices.setNoticeTitle(rs.getString("en_notice_title"));

                //添加到集合中
                noticeList.add(notices);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noticeList;
    }
}
