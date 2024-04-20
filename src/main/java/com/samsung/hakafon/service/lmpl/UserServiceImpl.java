package com.samsung.hakafon.service.lmpl;

import com.samsung.hakafon.dao.UserRepository;
import com.samsung.hakafon.domain.User;
import com.samsung.hakafon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {

        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) throw new RuntimeException("User with ID" + id + " not found");

        return userOptional.get();

    }

    @Override
    public User update(Long id, User user) {

        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) throw new RuntimeException("User with ID" + id + " not found");

        User updateUser = userOptional.get();
        updateUser.setUsername(user.getUsername());
        updateUser.setTgURl(user.getTgURl());

        return userRepository.save(updateUser);

    }

    @Override
    public void deleteById(Long id) {

        userRepository.deleteById(id);

    }
}
