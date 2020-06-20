package fr.gestibank.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gestibank.entity.user.User;
import fr.gestibank.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserWS {

@Autowired
UserRepository userdao;

@GetMapping("/users")
public List<User> getAllUsers(){
    return userdao.findAll();


}

@PostMapping(path="/users")
public User saveUser(@RequestBody User u) {
	return userdao.save(u);
}


@DeleteMapping(path="/users/{id}")
 public void deletUser(@PathVariable("id")Long id) {
  userdao.deleteById(id);
 }
 }

