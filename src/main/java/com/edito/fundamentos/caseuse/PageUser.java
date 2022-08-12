package com.edito.fundamentos.caseuse;

import com.edito.fundamentos.entity.User;
import com.edito.fundamentos.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class PageUser {
    private UserService userService;

    public PageUser(UserService userService) {
        this.userService = userService;
    }

    public List<User> getPage( int page, int size){
        return userService.getPageUsers(page, size);
    }
}
