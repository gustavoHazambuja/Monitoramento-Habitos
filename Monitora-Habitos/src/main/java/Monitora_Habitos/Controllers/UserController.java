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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Monitora_Habitos.Entities.User;
import Monitora_Habitos.Services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){

        User result = userService.createUser(user);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable UUID id){

        User result = userService.findById(id);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }

    @GetMapping(value = "/search/")
    public ResponseEntity<Page<User>> findByName(@RequestParam String name, Pageable pageable){

        Page<User> result = userService.findUserByName(name, pageable);

        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(Pageable pageable){

        Page<User> result = userService.getAllUsers(pageable);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable UUID id){

        userService.deleteUser(id);
    }


}
