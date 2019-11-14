package com.hd.blog.service;

import com.hd.blog.common.Exception.ApiException;
import com.hd.blog.model.domain.Authority;
import com.hd.blog.model.domain.User;
import com.hd.blog.repository.AuthorityRepository;
import com.hd.blog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private Logger log = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    private PasswordEncoder passwordEncoder;

    public UserService( UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerAccount(User user){
        userRepository.findByEmail(user.getEmail())
                .ifPresent(user1 -> {
                   throw new ApiException("Email Already exists.", HttpStatus.BAD_REQUEST);
                });

        return this.createUser(user.getEmail().toLowerCase(), user.getPassword(), user.getUserName());
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User createUser(String email, String password, String userName){
        User newUser = User.builder()
                           .email(email)
                           .password(password)
                           .userName(userName)
//                           .provider(null)
                           .build();
        //TODO : Authority
        userRepository.save(newUser);

        log.debug("Created New User: {}", newUser);
        return newUser;
    }

    public void updateUser(Long id, String email, String name, boolean activated){
        userRepository.findOneById(id).ifPresent((user -> {
            user.setEmail(email);
            log.debug("Changed Information for User: {}", user);
        }));
    }

    public Page<User> findAllUser(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public void deleteUser(Long userId){
        userRepository.findOneById(userId).ifPresent(user -> {
            userRepository.deleteById(userId);
        });
    }

    public List<String> getAuthorities(){
        return authorityRepository.findAll().stream().map(Authority::getName).collect(Collectors.toList());
    }

}
