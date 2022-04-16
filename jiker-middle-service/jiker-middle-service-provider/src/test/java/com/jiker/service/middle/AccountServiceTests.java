package com.jiker.service.middle;

import com.jiker.service.middle.domain.Account;
import com.jiker.service.middle.repository.AccountRepository;
import com.jiker.service.middle.service.AccountService;
import com.jiker.service.middle.service.impl.local.AccountLocalService;

import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class AccountServiceTests {

    @MockBean
    private AccountLocalService accountLocalService;

    @DubboReference(version = "${middle.service.version}", timeout = 3000)
    private AccountService accountService;

    @Test
    public void testFindAccountByAccountName() throws Exception {
        String accountName = "jiker-account1";

        Account account = new Account(accountName, "jiker-realname");
        Mockito.when(accountLocalService.getAccountByAccountName(accountName)).thenReturn(account);

        Account realAccount = accountService.getAccountByAccountName(accountName);
        assertThat(realAccount).isNotNull();
        assertThat(realAccount.getAccountName()).isEqualTo(accountName);
    }

}
