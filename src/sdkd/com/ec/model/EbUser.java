package sdkd.com.ec.model;

/**
 * 用户表
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUser {
    private String name;
    private String password;

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
