package com.kubepay.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {

}
