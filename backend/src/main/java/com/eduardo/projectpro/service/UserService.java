package com.eduardo.projectpro.service;

import com.eduardo.projectpro.domain.user.User;
import com.eduardo.projectpro.dto.user.UserDTO;
import com.eduardo.projectpro.exceptions.ResourceNotFoundException;
import com.eduardo.projectpro.exceptions.UserAlreadyExistException;
import com.eduardo.projectpro.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User createUser(UserDTO userDTO) {
        Optional<User> existedUser = userRepository.findByEmail(userDTO.email());

        if (existedUser.isPresent()) {
            throw new UserAlreadyExistException("User already exists with email: " + userDTO.email());
        }

        User user = new User();
        user.setFullName(userDTO.fullName());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        return userRepository.save(user);
    }

    public User updateUser(UUID id, UserDTO userDTO) {
        User user = findUserById(id);
        updateUserFields(user, userDTO);
        return userRepository.save(user);
    }

    private void updateUserFields(User user, UserDTO userDTO) {
        user.setFullName(userDTO.fullName());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
    }

    public void deleteUser(UUID id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }
}
