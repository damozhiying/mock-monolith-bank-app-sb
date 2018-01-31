package com.kubepay.bank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kubepay.bank.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    List<Appointment> findAll();

}
