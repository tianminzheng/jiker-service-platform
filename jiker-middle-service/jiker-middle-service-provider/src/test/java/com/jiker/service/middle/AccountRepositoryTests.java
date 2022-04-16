package com.jiker.service.middle;

import com.jiker.service.middle.domain.Account;
import com.jiker.service.middle.repository.AccountRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testFindAccountByAccountName() throws Exception {
        String accountName = "jiker-account1";

        this.entityManager.persist(new Account(accountName, "jiker-realname"));

        Account account = this.accountRepository.getAccountByAccountName(accountName);
        assertThat(account).isNotNull();
        assertThat(account.getAccountName()).isEqualTo(accountName);
    }

    @Test
    public void testFindAccountByNonExistedAccountName() throws Exception {
        this.entityManager.persist(new Account("jiker-account1", "jiker-realname"));

        Account account = this.accountRepository.getAccountByAccountName("jiker-account-non-existed");
        assertThat(account).isNull();
    }

    @Test
    public void testFindAccountBySameAccountName() throws Exception {
        String accountName = "jiker-account1";

        this.entityManager.persist(new Account(accountName, "jiker-realname"));
        this.entityManager.persist(new Account(accountName, "jiker-realname2"));

        Account account = this.accountRepository.getAccountByAccountName(accountName);
        assertThat(account).isNotNull();
    }
}
