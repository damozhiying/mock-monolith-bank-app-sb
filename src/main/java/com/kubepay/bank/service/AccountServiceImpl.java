package com.kubepay.bank.service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kubepay.bank.dao.AccountRepository;
import com.kubepay.bank.dao.BranchRepository;
import com.kubepay.bank.dao.CustomerRepository;
import com.kubepay.bank.dao.TransactionRepository;
import com.kubepay.bank.dao.master.AccountStatusRepository;
import com.kubepay.bank.dao.master.AccountTypeRepository;
import com.kubepay.bank.dao.master.CurrencyRepository;
import com.kubepay.bank.entity.Account;
import com.kubepay.bank.entity.Branch;
import com.kubepay.bank.entity.Customer;
import com.kubepay.bank.entity.Employee;
import com.kubepay.bank.entity.Payee;
import com.kubepay.bank.entity.Payer;
import com.kubepay.bank.entity.Transaction;
import com.kubepay.bank.entity.master.AccountStatus;
import com.kubepay.bank.entity.master.AccountType;
import com.kubepay.bank.entity.master.Currency;
import com.kubepay.bank.entity.master.TransactionStatus;
import com.kubepay.bank.entity.master.TransactionType;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    private BranchRepository branchRepository;

    private CustomerRepository customerRepository;

    private AccountTypeRepository accountTypeRepository;

    private CurrencyRepository currencyRepository;

    private AccountStatusRepository accountStatusRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Override
    public CreateAccountResponseCommand createAccount(@Valid CreateAccountRequestCommand cmd) {

        final Branch branch = branchRepository.findOne(cmd.getBranch());

        final Customer customer = customerRepository.findOne(cmd.getCustomer());

        final AccountType accountType = accountTypeRepository.findOne(cmd.getAccountType());

        final Currency baseCurrency = currencyRepository.findOne(cmd.getBaseCurrency());

        final BigDecimal balance = cmd.getBalance();

        final Double rate = cmd.getRate();

        final AccountStatus accountStatus = accountStatusRepository.findOne(cmd.getAccountStatus());

        final String description = cmd.getDescription();

        final boolean enabled = cmd.isEnabled();

        final Account account = new Account();
        account.setAccount(accountGen());
        account.setAccountStatus(accountStatus);
        account.setAccountType(accountType);
        account.setBalance(balance);
        account.setBaseCurrency(baseCurrency);
        account.setBranch(branch);
        account.setCustomer(customer);
        account.setDescription(description);
        account.setEnabled(enabled);
        account.setRate(rate);

        final Account saved = accountRepository.save(account);

        return new CreateAccountResponseCommand(saved);
    }

    public DepositToAccountResponseCommand deposit(@Valid DepositToAccountRequestCommand cmd) {

        final Account account;//RO
        final ZonedDateTime transactionDate;////RO
        final TransactionType transactionType;//RO
        final BigDecimal amount;//RO
        final Currency currency;//RO
        final BigDecimal startingBalance; //RO
        final Payee payee; //RO
        final Employee approver; //RO
        final TransactionStatus transactionStstus; //RO
        final String description ;
        final boolean enabled;


        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setApprover(approver);
        transaction.setCurrency(currency);
        transaction.setDescription(description);
        transaction.setEnabled(enabled);
        transaction.setPayee(payee);
        transaction.setStartingBalance(startingBalance);
        transaction.setTransactionDate(transactionDate);
        transaction.setTransactionStstus(transactionStstus);
        transaction.setTransactionType(transactionType);


        final Transaction saved = transactionService.save(transaction);

        return new DepositToAccountResponseCommand(saved);

    }

    public WithdrawFromAccountResponseCommand withdraw(WithdrawFromAccountRequestCommand cmd) {

        final Account account;//RO
        final ZonedDateTime transactionDate;////RO
        final TransactionType transactionType;//RO
        final BigDecimal amount;//RO
        final Currency currency;//RO
        final BigDecimal startingBalance; //RO
        final Payer payer; //RO
        final Employee approver; //RO
        final TransactionStatus transactionStstus; //RO

        User user = userService.findByUsername(principal.getName());

        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
        primaryAccountDao.save(primaryAccount);

        Date date = new Date();

        PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Withdraw from Primary Account", "Account",
                "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
        transactionService.savePrimaryWithdrawTransaction(primaryTransaction);

    }

    private String accountGen() {
        return UUID.randomUUID().toString();
    }

}
