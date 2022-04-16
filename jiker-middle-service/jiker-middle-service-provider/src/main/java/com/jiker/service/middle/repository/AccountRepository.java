package com.jiker.service.middle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jiker.service.middle.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByAccountName(String accountName);
}
