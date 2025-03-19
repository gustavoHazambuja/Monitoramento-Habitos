package Monitora_Habitos.Services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Monitora_Habitos.Entities.User;
import Monitora_Habitos.Exceptions.UserException;
import Monitora_Habitos.Repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user){

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findUserByName(String name){

        return userRepository.findUserByName(name).get();
    }

    @Transactional(readOnly = true)
    public Page<User> getAllUsers(Pageable pageable){

        Page<User> result = userRepository.findAll(pageable);
        return result;
    }

    @Transactional
    public void deleteUser(UUID id){

        if(!userRepository.existsById(id)){
            throw new UserException("Usuário com ID " + id + " não encontrado.");
        }

        userRepository.deleteById(id);
    }

}
