package com.garud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garud.entity.User;
import com.garud.repository.UserRepository;
import com.garud.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUser(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	@Override
	public User addUser(User user) {
		User persistedUser = userRepository.save(user);
		return persistedUser;
	}
}
