package sdkd.com.ec.model;

import java.util.Date;

/**
 * Created by sdust on 2016/7/6.
 */
public class EbNotice {
    private Integer noticeId;
    private String noticeTitle;
    private Date noticeTime;



    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }






}
