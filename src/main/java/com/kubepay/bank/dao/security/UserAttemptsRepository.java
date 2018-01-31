package com.kubepay.bank.dao.security;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.security.UserAttempts;

public interface UserAttemptsRepository extends CrudRepository<UserAttempts, Long> {

}
