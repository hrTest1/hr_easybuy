package sdkd.com.ec.model;

/**
 * Created by sdust on 2016/7/10.
 */
public class EbOderdetail {
    private Integer eodId;
    private String eoId;
    private String epId;
    private Integer eodQuantity;
    private Double eodCost;

    public Integer getEodId() {
        return eodId;
    }

    public void setEodId(Integer eodId) {
        this.eodId = eodId;
    }

    public String getEoId() {
        return eoId;
    }

    public void setEoId(String eoId) {
        this.eoId = eoId;
    }

    public String getEpId() {
        return epId;
    }

    public void setEpId(String epId) {
        this.epId = epId;
    }

    public Integer getEodQuantity() {
        return eodQuantity;
    }

    public void setEodQuantity(Integer eodQuantity) {
        this.eodQuantity = eodQuantity;
    }

    public Double getEodCost() {
        return eodCost;
    }

    public void setEodCost(Double eodCost) {
        this.eodCost = eodCost;
    }
}
