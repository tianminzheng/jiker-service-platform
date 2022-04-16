package com.jiker.service.middle;

import com.jiker.service.infrastructure.exception.ServiceException;
import com.jiker.service.middle.domain.Account;
import com.jiker.service.middle.repository.AccountRepository;
import com.jiker.service.middle.service.impl.local.AccountLocalService;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountLocalServiceTests {

    @Autowired
    private AccountLocalService accountLocalService;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testFindAccountByAccountName() throws Exception {
        String accountName = "jiker-account1";

        Account realAccount = accountLocalService.getAccountByAccountName(accountName);
        assertThat(realAccount).isNotNull();
        assertThat(realAccount.getAccountName()).isEqualTo(accountName);
    }

    @Test
    public void testAddExistedAccount() throws Exception {

        this.exception.expect(ServiceException.class);
        this.exception.expectMessage("Account is already existed");

        String accountName = "jiker-account1";

        Account account = new Account(accountName, "jiker-realname");

        Account realAccount = accountLocalService.addAccount(account);
        assertThat(realAccount).isNotNull();
        assertThat(realAccount.getAccountName()).isEqualTo(accountName);
    }
}
