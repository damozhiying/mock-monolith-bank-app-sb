package com.kubepay.bank.dao.security;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
