package edu.bjtu.springsecurity.security;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
class SecurityUserTest {
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void test1(){
        String encode = passwordEncoder.encode("admin");
        System.out.println("==============================");
        System.out.println(encode);
        System.out.println("==============================");
    }
}