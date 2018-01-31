package com.kubepay.bank.dao.master;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.master.AccountStatus;

public interface AccountStatusRepository extends CrudRepository<AccountStatus, Long> {

}
