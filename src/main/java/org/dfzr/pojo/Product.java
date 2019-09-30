package org.dfzr.pojo;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer proId;          //产品编号
    private String proName;         //产品名称
    private String proPrice;        //产品价格
    private String proAddress;      //产品产地
    private String proImage;        //产品样图
    private Integer isDelete;       //是否删除

    @Override
    public String toString() {
        return "Product{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proPrice='" + proPrice + '\'' +
                ", proAddress='" + proAddress + '\'' +
                ", proImage='" + proImage + '\'' +
                ", idDelete=" + isDelete +
                '}';
    }

    public Integer getIdDelete() {
        return isDelete;
    }

    public void setIdDelete(Integer idDelete) {
        this.isDelete = idDelete;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }
}
