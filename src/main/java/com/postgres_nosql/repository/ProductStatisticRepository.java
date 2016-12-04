package com.postgres_nosql.repository;

import com.postgres_nosql.model.ProductStatistic;
import com.postgres_nosql.model.info.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by igor on 12/4/16.
 */
@Repository
public interface ProductStatisticRepository extends JpaRepository<ProductStatistic,Integer> {
    //interesting query , combination of jpa query with json type query
    @Query(value = "SELECT * FROM statistic WHERE cast(info->>'productName'AS VARCHAR)=:productName",nativeQuery = true)
    ProductStatistic findByProductName(@Param("productName") String productName);
}
