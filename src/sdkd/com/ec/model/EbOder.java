package sdkd.com.ec.model;

import java.io.DataOutput;
import java.util.Date;

/**
 * Created by sdust on 2016/7/10.
 */
public class EbOder {
    private Integer eoId;
    private Integer eouserId;
    private String eouserName;
    private String eouserAddress;
    private Date eocreateTime;
    private Double eoCost;
    private  Integer eoStatus;
    private Integer eoType;

    public Integer getEoId() {
        return eoId;
    }

    public void setEoId(Integer eoId) {
        this.eoId = eoId;
    }

    public Integer getEouserId() {
        return eouserId;
    }

    public void setEouserId(Integer eouserId) {
        this.eouserId = eouserId;
    }

    public String getEouserName() {
        return eouserName;
    }

    public void setEouserName(String eouserName) {
        this.eouserName = eouserName;
    }

    public String getEouserAddress() {
        return eouserAddress;
    }

    public void setEouserAddress(String eouserAddress) {
        this.eouserAddress = eouserAddress;
    }

    public Date getEocreateTime() {
        return eocreateTime;
    }

    public void setEocreateTime(Date eocreateTime) {
        this.eocreateTime = eocreateTime;
    }

    public Double getEoCost() {
        return eoCost;
    }

    public void setEoCost(Double eoCost) {
        this.eoCost = eoCost;
    }

    public Integer getEoStatus() {
        return eoStatus;
    }

    public void setEoStatus(Integer eoStatus) {
        this.eoStatus = eoStatus;
    }

    public Integer getEoType() {
        return eoType;
    }

    public void setEoType(Integer eoType) {
        this.eoType = eoType;
    }
}
