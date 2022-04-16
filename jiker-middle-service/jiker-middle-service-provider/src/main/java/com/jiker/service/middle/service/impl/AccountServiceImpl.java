package com.jiker.service.middle.service.impl;

import com.jiker.service.middle.domain.Account;
import com.jiker.service.middle.service.AccountService;
import com.jiker.service.middle.service.impl.local.AccountLocalService;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(version = "${middle.service.version}")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountLocalService accountLocalService;

    @Override
    public Account getAccountById(Long id) {
        return accountLocalService.getAccountById(id);
    }

    @Override
    public Account getAccountByAccountName(String accountName) {
        return accountLocalService.getAccountByAccountName(accountName);
    }
}
