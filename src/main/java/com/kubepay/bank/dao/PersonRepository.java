package com.kubepay.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
