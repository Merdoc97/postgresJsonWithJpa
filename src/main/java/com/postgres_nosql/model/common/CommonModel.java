package com.postgres_nosql.model.common;

import com.postgres_nosql.model.info.Info;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Created by igor on 12/4/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "statistic")
public abstract class CommonModel<T extends Info> extends Statistic {

    public abstract T getInfo();
    public abstract void setInfo(T info);

}
