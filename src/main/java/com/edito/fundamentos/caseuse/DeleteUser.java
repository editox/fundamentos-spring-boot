package com.edito.fundamentos.caseuse;

import com.edito.fundamentos.entity.User;
import com.edito.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void delete(Long id) {
        userService.delete(id);
    }
}
