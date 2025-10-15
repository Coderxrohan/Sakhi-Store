package com.sakhi.store.service.interfaces;
import com.sakhi.store.model.User;
public interface UserService {
    User register(User user);
    String login(String email, String password);
    User findById(Long id);
}
