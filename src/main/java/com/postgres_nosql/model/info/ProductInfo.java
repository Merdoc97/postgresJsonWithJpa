package com.postgres_nosql.model.info;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by igor on 12/4/16.
 */
public class ProductInfo implements Info {
    private String productName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createDate;

    private String productAdditionalInfo;

    public ProductInfo() {
    }

    public ProductInfo(String productName, Date createDate, String productAdditionalInfo) {
        this.productName = productName;
        this.createDate = createDate;
        this.productAdditionalInfo = productAdditionalInfo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getProductAdditionalInfo() {
        return productAdditionalInfo;
    }

    public void setProductAdditionalInfo(String productAdditionalInfo) {
        this.productAdditionalInfo = productAdditionalInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductInfo info = (ProductInfo) o;

        if (!productName.equals(info.productName)) return false;
        if (!createDate.equals(info.createDate)) return false;
        return productAdditionalInfo.equals(info.productAdditionalInfo);

    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        result = 31 * result + createDate.hashCode();
        result = 31 * result + productAdditionalInfo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productName='" + productName + '\'' +
                ", createDate=" + createDate +
                ", productAdditionalInfo='" + productAdditionalInfo + '\'' +
                '}';
    }
}
