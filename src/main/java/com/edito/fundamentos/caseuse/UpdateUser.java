package com.edito.fundamentos.caseuse;

import com.edito.fundamentos.entity.User;
import com.edito.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUser, Long id) {
        return userService.update(newUser, id);
    }
}
