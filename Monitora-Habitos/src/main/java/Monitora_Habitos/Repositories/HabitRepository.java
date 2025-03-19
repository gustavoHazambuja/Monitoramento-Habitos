package Monitora_Habitos.Repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import Monitora_Habitos.Entities.Habit;

public interface HabitRepository extends JpaRepository<Habit, UUID> {
    
    Optional <Habit> findHabitByName(String name);
}
