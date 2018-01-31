package com.kubepay.bank.dao.master;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.master.TransactionType;

public interface TransactionTypeRepository extends CrudRepository<TransactionType, Long> {

}
