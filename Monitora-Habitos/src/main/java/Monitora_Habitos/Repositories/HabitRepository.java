package Monitora_Habitos.Repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import Monitora_Habitos.Entities.Habit;

public interface HabitRepository extends JpaRepository<Habit, UUID> {
    
    Page<Habit> findHabitByNameContainingIgnoreCase(String name, Pageable pageable);
}
