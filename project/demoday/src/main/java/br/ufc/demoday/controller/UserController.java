package br.ufc.demoday.controller;
import br.ufc.demoday.model.User;
import br.ufc.demoday.service.UserService;

import java.util.ArrayList;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/users")
@PreAuthorize("isAuthenticated()")
public class UserController {

    @Autowired
    UserService userService;

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping("/")
    public ResponseEntity<ArrayList<User>> findAll(){
        return new ResponseEntity<ArrayList<User>>(userService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping("/{userId}")
    public ResponseEntity<User> find(@PathVariable int userId){
        return new ResponseEntity<User>(userService.find(userId), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping("/{userId}")
    public void save(@PathVariable int userId, @RequestBody User user){
        userService.save(userId, user);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PutMapping("/{userId}")
    public void update(@PathVariable int userId, @RequestBody User user){
        userService.update(userId, user);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{userId}")
    public void delete(@PathVariable int userId){
        userService.delete(userId);
    }

}
