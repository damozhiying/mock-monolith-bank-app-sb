package com.kubepay.bank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findAll();

}
