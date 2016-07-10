package sdkd.com.ec.dao.impl;

import java.sql.*;

/**
 * 用户DAO
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUserDao {
    public static boolean state=false;
    public EbUserDao(){}

    public void setLoginState(boolean state){
        this.state=state;
    }
    public static boolean isLogin(){
        return state;
    }
}
