package com.hd.blog.service;

import com.hd.blog.model.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    private Logger _log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String email;

    private String password;

    private String userName;

    private User user;

    @Before
    public void setup(){
        email = "navyguy113@gmail.com";
        password = passwordEncoder.encode("1234");
        userName = "LEO";
        user = User.builder()
                    .email(email)
                    .password(password)
                    .userName(userName)
                    .build();
    }

    @Test
    @Order(1)
    public void 사용자를_추가한다(){
        user = userService.createUser(email,password,userName);

        assertThat(user, is(notNullValue()));
        assertThat(user.getEmail(), is(email));
        assertThat(user.getPassword(), is(password));
        assertThat(user.getUserName(), is(userName));
        _log.info("Created User: {}", user);
    }

    @Test
    @Order(2)
    public void 사용자를_이메일로_조회한다(){
        User newUser = userService.findByEmail(email).orElse(null);

        assertThat(newUser, is(notNullValue()));
        assertThat(newUser.getId(), is(0L));
        assertThat(newUser.getEmail(), is(email));
    }


}
