package com.ty.Bookmanagement.Book_management_boot_prc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
