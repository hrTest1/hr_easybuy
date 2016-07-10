package sdkd.com.ec.model;

/**
 * Created by canhe on 2016/7/6.
 */
public class EbProduct {
    private Integer ep_id;
    private String ep_name;
    private String ep_description;
    private Double ep_price;
    private Integer ep_stock;
    private Integer epc_id;
    private Integer epc_chile_id;
    private String ep_file_name;
    private String ep_img;
    private int ep_isdiscount;
    private int ep_clickrate;

    public int getEp_clickrate() {
        return ep_clickrate;
    }
    public void setEp_clickrate(int ep_clickrate) {
        this.ep_clickrate = ep_clickrate;
    }
    public int getEp_isdiscount() {
        return ep_isdiscount;
    }
    public void setEp_isdiscount(int ep_isdiscount) {
        this.ep_isdiscount = ep_isdiscount;
    }

    public String getEp_img() {
        return ep_img;
    }
    public void setEp_img(String epImg) {
        ep_img = epImg;
    }
    public Integer getEp_id() {
        return ep_id;
    }
    public void setEp_id(Integer epId) {
        ep_id = epId;
    }
    public String getEp_name() {
        return ep_name;
    }
    public void setEp_name(String epName) {
        ep_name = epName;
    }
    public String getEp_description() {
        return ep_description;
    }
    public void setEp_description(String epDescription) {
        ep_description = epDescription;
    }
    public Double getEp_price() {
        return ep_price;
    }
    public void setEp_price(Double epPrice) {
        ep_price = epPrice;
    }
    public Integer getEp_stock() {
        return ep_stock;
    }
    public void setEp_stock(Integer epStock) {
        ep_stock = epStock;
    }
    public Integer getEpc_id() {
        return epc_id;
    }
    public void setEpc_id(Integer epcId) {
        epc_id = epcId;
    }
    public Integer getEpc_chile_id() {
        return epc_chile_id;
    }
    public void setEpc_chile_id(Integer epcChileId) {
        epc_chile_id = epcChileId;
    }
    public String getEp_file_name() {
        return ep_file_name;
    }
    public void setEp_file_name(String epFileName) {
        ep_file_name = epFileName;
    }

}
