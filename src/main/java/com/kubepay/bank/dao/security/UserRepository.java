package com.kubepay.bank.dao.security;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.security.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);

    @Override
    void delete(User user);

}
