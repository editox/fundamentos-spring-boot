package com.edito.fundamentos.service;

import com.edito.fundamentos.entity.User;
import com.edito.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOG.info("Usuario insertado: " + user))
                .forEach(user -> userRepository.save(user));
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User save(User newUser) {
        return userRepository.save(newUser);
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User newUser, Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setBirthDate(newUser.getBirthDate());
                    user.setName(newUser.getName());
                    return userRepository.save(user);
                }).get();
    }

    public List<User> getPageUsers( int page, int size) {
        return userRepository.findAll(PageRequest.of(page,size)).getContent();
    }

    public Page getPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
