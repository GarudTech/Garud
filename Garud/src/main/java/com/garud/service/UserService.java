package com.garud.service;

import com.garud.entity.User;

public interface UserService {
	User getUser(String email);
	User addUser(User user);
}
