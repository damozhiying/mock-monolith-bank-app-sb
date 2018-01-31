package com.kubepay.bank.dao.master;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.master.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {

}
