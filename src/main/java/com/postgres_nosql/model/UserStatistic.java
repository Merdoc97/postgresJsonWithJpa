package com.postgres_nosql.model;

import com.postgres_nosql.model.common.CommonModel;
import com.postgres_nosql.model.info.UserInfo;
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
@TypeDef(name = "userInfo", typeClass = JSONBUserType.class, parameters = {
        @Parameter(name = JSONBUserType.CLASS, value = "com.postgres_nosql.model.info.UserInfo")})
public class UserStatistic extends CommonModel<UserInfo> {
    @Type(type = "userInfo")
    @Column(name = "info")
    private UserInfo userInfo;

    public UserStatistic() {
    }

    public UserStatistic(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public UserInfo getInfo() {
        return userInfo;
    }

    @Override
    public void setInfo(UserInfo info) {
        this.userInfo = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UserStatistic that = (UserStatistic) o;

        return userInfo.equals(that.userInfo);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + userInfo.hashCode();
        return result;
    }
}
