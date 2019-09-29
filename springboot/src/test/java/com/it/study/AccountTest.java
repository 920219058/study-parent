package com.it.study;

import com.it.study.demain.Account;
import com.it.study.mapper.AccountAmpper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class AccountTest {

    @Resource
    private AccountAmpper accountAmpper;

    @Test
    public void accountTest(){
        List<Account> accounts = accountAmpper.finalAll();
        for (Account account : accounts) {
            System.out.println("-------------------------");
            System.out.println(account);
            System.out.println(account.getStudent());
        }
    }
}
