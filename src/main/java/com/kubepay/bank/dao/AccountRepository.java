package com.kubepay.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByAccount (String account);

}
