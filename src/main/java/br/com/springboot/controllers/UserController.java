package br.com.springboot.controllers;

import br.com.springboot.model.User;
import br.com.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){

        Optional<User> userFind = this.userRepository.findById(id);
        if (userFind.isPresent()) {
            return userFind.get();
        }
        return null;
    }

    @PostMapping("/")
    public User user(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @GetMapping("/list")
    public List<User> list(){
        return this.userRepository.findAll();

    }@GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id){
        return this.userRepository.findAllMoreThan(id);
    }
    @GetMapping("/findByName/{nome}")
    public List<User> findByNome(@PathVariable("nome") String nome){
        return this.userRepository.findByNomeIgnoreCase(nome);
    }
}
