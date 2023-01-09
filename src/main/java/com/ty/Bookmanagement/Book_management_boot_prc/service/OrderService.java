package com.ty.Bookmanagement.Book_management_boot_prc.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Bookmanagement.Book_management_boot_prc.dao.CartDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dao.OrderDao;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Cart;
import com.ty.Bookmanagement.Book_management_boot_prc.dto.Orders;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.InvalidCredentialsException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.NoSuchIdFoundException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToDeleteException;
import com.ty.Bookmanagement.Book_management_boot_prc.exception.UnableToUpdateException;
import com.ty.Bookmanagement.Book_management_boot_prc.util.ResponseStructure;

@Service
public class OrderService {
	private static final Logger logger = Logger.getLogger(SellerService.class);
	@Autowired
	private OrderDao dao;
	@Autowired
	private CartDao cartDao;

	public ResponseEntity<ResponseStructure<Orders>> saveOrder(Orders orders) {
		
		LocalDateTime dateTime = LocalDateTime.now();
		String date = String.valueOf(dateTime);
		orders.setDate(date);
		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data Saved");
		cartDao.saveCart(orders.getCart());
		responseStructure.setData(dao.saveOrder(orders));
		logger.info("SAVED ORDER TO ORDER  TABLE");
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Orders>> updateOrder(Orders orders, int id) {

		Optional<Orders> orders1 = dao.findOrdersById(id);
		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
		if (orders1.isPresent()) {
			LocalDateTime dateTime = LocalDateTime.now();
			orders.setDate(String.valueOf(dateTime));
			Orders o1 = orders1.get();
			orders.setId(id);
			orders.setCart(o1.getCart());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateOrder(orders));
			logger.info("UPDATED ORDER");
			return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);
		}
		logger.error("NO SUCH ORDER FOUND");

		throw new UnableToUpdateException("UnableToUpdate");

	}

	public ResponseEntity<ResponseStructure<Orders>> getOrderById(int id) {
		Optional<Orders> orders1 = dao.findOrdersById(id);
		ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
		if (orders1.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Received");
			responseStructure.setData(dao.findOrdersById(id).get());
			logger.info("FOUND ORDER");
			return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.OK);

		}
		logger.error("NO SUCH ID FOUND");
		throw new NoSuchIdFoundException();

	}

	public ResponseEntity<ResponseStructure<String>> deleteOrderById(int id) {
		Optional<Orders> orders1 = dao.findOrdersById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		if (orders1.isPresent()) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.deleteOrders(id));
			logger.warn("DELETED ORDER");
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);

		}
		logger.error("Order not found");
		throw new UnableToDeleteException("UnableToDelete");

	}

	public ResponseEntity<ResponseStructure<Orders>> setOrdersByBuyer(String email, String password, int id) {
		Orders orders = dao.getByEmail(email);
		if (orders.getEmail().equalsIgnoreCase(email) && orders.getPassword().equalsIgnoreCase(password)) {
			Cart cart = cartDao.getCartById(id).get();
			orders.setCart(cart);
			LocalDateTime dateTime = LocalDateTime.now();
			String date = String.valueOf(dateTime);
			orders.setDate(date);
			ResponseStructure<Orders> responseStructure = new ResponseStructure<Orders>();
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("login successfull");
			responseStructure.setData(dao.saveOrder(orders));
			logger.info("order placed by buyer");
			return new ResponseEntity<ResponseStructure<Orders>>(responseStructure, HttpStatus.CREATED);
		}
		logger.error("FAILED TO PLACE ORDER");
		throw new InvalidCredentialsException();
	}

}
