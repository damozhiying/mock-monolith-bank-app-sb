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
@Table(name = "tbl_employment_level")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class EmploymentLevel extends AbstractBaseMaster implements Serializable {

    private static final long serialVersionUID = -6561305654020501011L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employmentLevelSequence")
    @SequenceGenerator(name = "employmentLevelSequence", sequenceName = "sequence_employment_level")
    private Long id;

    @Column(name="employment_level", unique=true, nullable=false, length=32)
    private String employmentLevel;

    public EmploymentLevel(final String employmentLevel) {

        this.employmentLevel = employmentLevel;
        this.enabled = true;
    }

    @Override
    public String toString() {

        return this.employmentLevel;
    }

}
