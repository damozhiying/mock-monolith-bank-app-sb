package com.kubepay.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Payee;

public interface PayeeRepository extends CrudRepository<Payee, Long> {

}
