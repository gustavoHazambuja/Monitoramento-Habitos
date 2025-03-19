package Monitora_Habitos.Repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Monitora_Habitos.Entities.User;


public interface UserRepository extends JpaRepository<User, UUID> {
    
    Optional<User> findUserByName(String name);
}
