package com.edito.fundamentos.caseuse;

import com.edito.fundamentos.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PageableUser {

    private UserService userService;

    public PageableUser(UserService userService) {
        this.userService = userService;
    }

    public Page getPageable(Pageable pageable){
       return userService.getPageable(pageable);
    }
}
