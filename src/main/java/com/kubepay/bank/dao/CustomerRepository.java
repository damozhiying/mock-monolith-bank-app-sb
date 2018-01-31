package com.kubepay.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
