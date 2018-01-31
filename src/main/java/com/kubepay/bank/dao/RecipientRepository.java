package com.kubepay.bank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Recipient;

public interface RecipientRepository extends CrudRepository<Recipient, Long> {

    List<Recipient> findAll();

    Recipient findByName(String name);

    void deleteByName(String name);
}

