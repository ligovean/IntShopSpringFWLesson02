package com.geekbrains.geekmarketwinter.repositories;

import com.geekbrains.geekmarketwinter.entites.Order;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>, JpaSpecificationExecutor<Order> {
}
