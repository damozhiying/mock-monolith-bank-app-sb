package com.kubepay.bank.dao.security;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.security.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
