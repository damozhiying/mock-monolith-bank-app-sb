package com.kubepay.bank.dao.master;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.master.TransactionStatus;

public interface TransactionStatusRepository extends CrudRepository<TransactionStatus, Long> {

}
