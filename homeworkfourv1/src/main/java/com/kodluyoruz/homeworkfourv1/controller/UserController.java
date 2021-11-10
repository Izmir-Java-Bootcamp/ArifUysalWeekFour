package com.kodluyoruz.homeworkfourv1.controller;


import com.kodluyoruz.homeworkfourv1.model.dto.BasketDto;
import com.kodluyoruz.homeworkfourv1.model.dto.UserDto;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateUserRequest;
import com.kodluyoruz.homeworkfourv1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public UserDto createUser(@RequestBody CreateUpdateUserRequest request){
        return service.createUser(request);
    }
    @GetMapping("{id}")
    public UserDto getUser(@PathVariable int id){
        return service.getUser(id);
    }
    @GetMapping
    public List<UserDto> getUsers(){
        return service.getUsers();
    }
    @PutMapping
    public UserDto updateUser(@PathVariable int id , CreateUpdateUserRequest request){
        return service.updateUser(id,request);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }
    @GetMapping("{id}/basket")
    public BasketDto getBasket(int id){
        return service.getBasket(id);
    }
}