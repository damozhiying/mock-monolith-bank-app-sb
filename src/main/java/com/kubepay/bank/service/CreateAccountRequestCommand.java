package com.kubepay.bank.service;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateAccountRequestCommand {

    private Long account;

    private Long branch;

    private Long customer;

    private Long accountType;

    private Long baseCurrency;

    private BigDecimal balance;

    private Double rate;

    private Long accountStatus;

    private String description;

    private boolean enabled;

    private String createdBy;

}
