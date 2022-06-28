package com.spring.springordersecuritydemo.restapi;

import com.spring.springordersecuritydemo.entity.Account;
import com.spring.springordersecuritydemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/accounts")
public class AccountApi {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(path = "login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Account account) {
        Account exitingAccount = accountRepository.findAccountByUsername(account.getUsername());
        if (exitingAccount == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login Failed!");
        }
        boolean result = passwordEncoder.matches(account.getPasswordHash(), exitingAccount.getPasswordHash());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @RequestMapping(path = "register", method = RequestMethod.POST)
    public Account register(@RequestBody Account account) {
        account.setPasswordHash(passwordEncoder.encode(account.getPasswordHash()));
        accountRepository.save(account);
        return account;
    }
}
