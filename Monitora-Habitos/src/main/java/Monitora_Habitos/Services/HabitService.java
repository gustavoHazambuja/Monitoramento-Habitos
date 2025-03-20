package Monitora_Habitos.Services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Monitora_Habitos.Entities.Habit;
import Monitora_Habitos.Exceptions.HabitException;
import Monitora_Habitos.Repositories.HabitRepository;


@Service
public class HabitService {
    
    @Autowired
    private HabitRepository habitRepository;

    @Transactional
    public Habit createHabit(Habit habit){

        return habitRepository.save(habit);
    }

    @Transactional(readOnly = true)
    public Habit findById(UUID id){

        if(!habitRepository.existsById(id)){
            throw new HabitException("Hábito com id " + id + " não encontrado.");
        }

        return habitRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public Page<Habit> findHabitByName(String name, Pageable pageable){
        
        Page<Habit> result = habitRepository.findHabitByName(name, pageable);

        return result;
    }

    @Transactional(readOnly = true)
    public Page<Habit> getAllHabits(Pageable pageable){

        Page<Habit> result = habitRepository.findAll(pageable);

        return result;
    }

    @Transactional
    public void deleteHabit(UUID id){

        if(!habitRepository.existsById(id)){
            throw new HabitException("Hábito com id " + id + " não encontrado.");
        }

        habitRepository.deleteById(id);
    }

    public Habit updateHabit(UUID id, Habit habit){

        if(!habitRepository.existsById(id)){
            throw new HabitException("Hábito com id " + id + " não encontrado.");
        }

        Habit result = habitRepository.findById(id).get();

        result.setName(habit.getName());
        result.setFrequencyHabit(habit.getFrequencyHabit());

        return habitRepository.save(result);
    }
}
