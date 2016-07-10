package sdkd.com.ec.model;

/**
 * 用户表
 * Created by SDUST-132 on 2016/7/5.
 */
public class EbUser {
    private Integer id;
    private String name;
    private String password;
    private  String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



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
