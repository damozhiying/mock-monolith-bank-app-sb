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
@Table(name = "tbl_job_title")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class JobTitle extends AbstractBaseMaster implements Serializable {

    private static final long serialVersionUID = -8504794737868907135L;

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "jobTitleSequence")
    @SequenceGenerator(name = "jobTitleSequence", sequenceName = "sequence_job_title")
    private Long id;

    @Column(name="job_title", unique=true, nullable=false, length=32)
    private String jobTitle;

    public JobTitle(final String jobTitle) {

        this.jobTitle = jobTitle;
        this.enabled = true;
    }

    @Override
    public String toString() {

        return this.jobTitle;
    }

}
