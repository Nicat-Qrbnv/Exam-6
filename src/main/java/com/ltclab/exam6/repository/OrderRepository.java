package com.ltclab.exam6.repository;

import com.ltclab.exam6.entity.UserOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<UserOrder, Long> {
}