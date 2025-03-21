package Monitora_Habitos.Repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import Monitora_Habitos.Entities.User;


public interface UserRepository extends JpaRepository<User, UUID> {
    
    Page<User> findUserByNameContainingIgnoreCase(String name, Pageable pageable);
}
