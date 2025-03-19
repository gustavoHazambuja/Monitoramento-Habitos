package Monitora_Habitos.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Monitora_Habitos.Entities.HabitRegister;

public interface HabitRegisterRepository extends JpaRepository<HabitRegister, UUID> {
    
}
