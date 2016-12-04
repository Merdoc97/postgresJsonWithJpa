package com.postgres_nosql.repository;

import com.postgres_nosql.model.common.CommonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by igor on 12/4/16.
 */
@Repository
public interface CommonModelRepository extends JpaRepository<CommonModel,Integer> {
}
