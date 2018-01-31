package com.kubepay.bank.service;

public interface AccountService {

    CreateAccountResponseCommand createAccount(CreateAccountRequestCommand cmd);

}
