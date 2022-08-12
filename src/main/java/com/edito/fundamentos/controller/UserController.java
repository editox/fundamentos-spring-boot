package com.edito.fundamentos.controller;

import com.edito.fundamentos.caseuse.*;
import com.edito.fundamentos.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    //create. read. update, delete

    private GetUser getUser;
    private CreateUser createUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private PageUser pageUser;

    private PageableUser pageableUser;

    public UserController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser, PageUser pageUser, PageableUser pageableUser) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.pageUser = pageUser;
        this.pageableUser = pageableUser;
    }

    @GetMapping()
    List<User> get() {
        return getUser.getAll();
    }

    @PostMapping()
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(newUser, id), HttpStatus.OK);
    }

    @GetMapping("/lista")
    List<User> getPage(@RequestParam int page, @RequestParam int size){

        return pageUser.getPage(page, size);
    }

    @GetMapping("/pageable")
    Page getPageable(Pageable pageable){

        return pageableUser.getPageable(pageable);
    }
}
