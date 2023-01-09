package com.ty.Bookmanagement.Book_management_boot_prc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Bookmanagement.Book_management_boot_prc.dto.Orders;
import com.ty.Bookmanagement.Book_management_boot_prc.repo.OrderRepo;

@Repository
public  class OrderDao {
	@Autowired
	private OrderRepo repo;
	
	public Orders saveOrder(Orders order)
	{
		return repo.save(order);
	}
	public Orders updateOrder(Orders order)
	{
		return repo.save(order);
	}
	
	public Optional<Orders> findOrdersById(int id)
	{
		return repo.findById(id);
	}

	public List<Orders> getOrders() {
		return repo.findAll();
		
	} 
	
	public Orders getByEmail(String email) {
		return repo.getByEmail(email);
	}
	

	public String deleteOrders(int id)
	{
		repo.deleteById(id);
		return "deleted";
		
	}

}
