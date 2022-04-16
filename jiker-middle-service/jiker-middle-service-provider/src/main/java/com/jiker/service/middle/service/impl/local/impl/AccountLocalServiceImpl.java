package com.jiker.service.middle.service.impl.local.impl;

import com.jiker.service.infrastructure.exception.ServiceException;
import com.jiker.service.middle.domain.Account;
import com.jiker.service.middle.repository.AccountRepository;
import com.jiker.service.middle.repository.ProductRepository;
import com.jiker.service.middle.service.impl.local.AccountLocalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountLocalServiceImpl implements AccountLocalService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {
        Account existedAccount = this.getAccountByAccountName(account.getAccountName());
        if(existedAccount != null) {
            throw new ServiceException("Account is already existed");
        }

        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.getOne(id);
    }

    @Override
    public Account getAccountByAccountName(String accountName) {
        return accountRepository.getAccountByAccountName(accountName);
    }
}
