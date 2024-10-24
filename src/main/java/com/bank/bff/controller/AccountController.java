package com.bank.bff.controller;

import com.bank.bff.model.BankAccount;
import com.bank.bff.service.AccountService;
import com.bank.bff.service.TransactionService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {

    private final TransactionService transactionService;
    private final AccountService accountService;

    public AccountController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @PostMapping("/newAccount")
    public void CreateNewAccount(@RequestBody BankAccount newAccount) {
        accountService.createNewAccountForCustomer(newAccount.getCustomerUuid(), newAccount.getBalance(), newAccount.getCustomerName());
    }
}
