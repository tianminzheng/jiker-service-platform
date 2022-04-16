package com.jiker.service.middle.service;

import com.jiker.service.middle.domain.Account;

public interface AccountService {
    Account getAccountById(Long id);

    Account getAccountByAccountName(String accountName);

}
