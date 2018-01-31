package com.kubepay.bank.entity.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kubepay.bank.entity.AbstractBaseMaster;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_department")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Department extends AbstractBaseMaster implements Serializable {

    private static final long serialVersionUID = -4289613981302134054L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "departmentSequence")
    @SequenceGenerator(name = "departmentSequence", sequenceName = "sequence_department")
    private Long id;

    @Column(name="department", unique=true, nullable=false, length=32)
    private String department;

    public Department(final String department) {

        this.department = department;
        this.enabled = true;
    }

    @Override
    public String toString() {

        return this.department;
    }
}
