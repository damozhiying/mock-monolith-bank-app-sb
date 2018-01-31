package com.kubepay.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
