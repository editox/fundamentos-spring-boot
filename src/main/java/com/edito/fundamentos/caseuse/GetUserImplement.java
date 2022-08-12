package com.edito.fundamentos.caseuse;

import com.edito.fundamentos.entity.User;
import com.edito.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
