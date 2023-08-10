package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.AccountDTO;
import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/accounts")
    public List<AccountDTO> getAccounts() {
        List<Account> allAccounts = accountRepository.findAll();

        List<AccountDTO> convertedList = allAccounts.stream().map(AccountDTO::new).collect(Collectors.toList());

        return convertedList;
    }

    @RequestMapping("/accounts/{id}")
    public AccountDTO getAccountById(@PathVariable Long id){
        Account account = accountRepository.findById(id).orElse(null);
        return new  AccountDTO(account);
    }
}
