package com.postgres_nosql.model;

import com.postgres_nosql.model.common.CommonModel;
import com.postgres_nosql.model.info.ProductInfo;
import com.postgres_nosql.model.types.JSONBUserType;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by igor on 12/4/16.
 */
@Entity
@TypeDef(name = "productInfo", typeClass = JSONBUserType.class, parameters = {
        @Parameter(name = JSONBUserType.CLASS, value = "com.postgres_nosql.model.info.ProductInfo")})
public class ProductStatistic extends CommonModel<ProductInfo> {
    @Type(type = "productInfo")
    @Column(name = "info")
    private ProductInfo info;

    public ProductStatistic() {
    }

    public ProductStatistic(ProductInfo info) {
        this.info = info;
    }

    @Override
    public ProductInfo getInfo() {
        return info;
    }

    @Override
    public void setInfo(ProductInfo info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ProductStatistic that = (ProductStatistic) o;

        return info.equals(that.info);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + info.hashCode();
        return result;
    }
}
