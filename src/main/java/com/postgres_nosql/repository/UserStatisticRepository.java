package com.postgres_nosql.repository;

import com.postgres_nosql.model.UserStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by igor on 12/4/16.
 */
@Repository
public interface UserStatisticRepository extends JpaRepository<UserStatistic,Integer> {
    @Query(value = "select * from statistic u where cast(info->>'userEmail'AS VARCHAR)=:email",nativeQuery = true)
    UserStatistic getUserByEmail(@Param("email") String email);
}
