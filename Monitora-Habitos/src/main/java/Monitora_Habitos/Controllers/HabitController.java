package Monitora_Habitos.Controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Monitora_Habitos.Entities.Habit;
import Monitora_Habitos.Services.HabitService;

@RestController
@RequestMapping(value = "/habits")
public class HabitController {
    
    @Autowired
    private HabitService habitService;

    @PostMapping
    public ResponseEntity<Habit> createHabit(@RequestBody Habit habit){

        Habit result = habitService.createHabit(habit);

        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Habit> findById(@PathVariable UUID id){

        Habit result = habitService.findById(id);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<Habit>> findByName(@RequestParam String name, Pageable pageable){

        Page<Habit> result = habitService.findHabitByName(name, pageable);

        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<Page<Habit>> getAll(Pageable pageable){

        Page<Habit> result = habitService.getAllHabits(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteHabit(@PathVariable UUID id){

        habitService.deleteHabit(id);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Habit> updateHabit(@PathVariable UUID id, @RequestBody Habit habit){

        Habit result = habitService.updateHabit(id, habit);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
