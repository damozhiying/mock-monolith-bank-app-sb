package com.kubepay.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Branch;

public interface BranchRepository extends CrudRepository<Branch, Long> {

}
