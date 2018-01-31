package com.kubepay.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Payer;

public interface PayerRepository extends CrudRepository<Payer, Long> {

}
