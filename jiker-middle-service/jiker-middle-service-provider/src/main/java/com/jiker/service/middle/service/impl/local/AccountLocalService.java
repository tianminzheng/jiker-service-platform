package com.jiker.service.middle.service.impl.local;

import com.jiker.service.middle.domain.Account;

public interface AccountLocalService {

	//添加用户账户
    Account addAccount(Account account);

    //根据账户Id获取用户账户
    Account getAccountById(Long id);

    //根据账户名称获取用户账户
    Account getAccountByAccountName(String accountName);
}
