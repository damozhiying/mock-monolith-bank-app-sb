package com.kubepay.bank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kubepay.bank.entity.master.Department;
import com.kubepay.bank.entity.master.EmploymentLevel;
import com.kubepay.bank.entity.master.JobTitle;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_employee")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -6116836374403403002L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employeeSequence")
    @SequenceGenerator(name = "employeeSequence", sequenceName = "sequence_employee")
    private Long id;

    @Column(name = "sap_id", nullable = false, length = 32)
    private String sapId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(nullable = false)
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Department department;

    @Column(name = "manager", nullable = false)
    private Long manager;

    @ManyToOne
    @JoinColumn(nullable = false)
    private EmploymentLevel employmentLevel;

}
