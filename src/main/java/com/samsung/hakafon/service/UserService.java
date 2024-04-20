package com.samsung.hakafon.service;

import com.samsung.hakafon.domain.User;

import java.util.List;

public interface UserService {

    User add(User user);

    List<User> getAll();

    User getById(Long id);

    User update(Long id, User user);

    void deleteById(Long id);

}
