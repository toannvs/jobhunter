package info.toannvs.jobhunter.service;

import info.toannvs.jobhunter.domain.User;
import info.toannvs.jobhunter.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleGetUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public List<User> handleGetAllUsers() {
        return this.userRepository.findAll();
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public User handleUpdateUser(User user) {
        User existingUser = this.userRepository.findById(user.getId()).orElse(null);
        if (existingUser == null) {
            return null;
        }
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return this.userRepository.save(existingUser);
    }

    public void handleDeleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    public User handleGetUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
