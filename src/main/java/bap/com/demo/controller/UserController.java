package bap.com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bap.com.demo.model.Users;
import bap.com.demo.service.UserService;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
//@Controller + ResponseBODY
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService Userservice;

	//Get List Data
	@GetMapping("/")

	public ResponseEntity<List<Users>> getListUser() {
		return new ResponseEntity<>((List<Users>) Userservice.findAll(), HttpStatus.OK);

	}

	// Get User by id
	@GetMapping("/user/{id}")
	public ResponseEntity<Users> getUser(@PathVariable("id") Long id) {
		// @PathVariable lay ra thông tin trong URL
		Optional<Users> userOptional = Userservice.findById(id);
		return userOptional.map(users -> new ResponseEntity<>(users, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	// Create User
	@PostMapping("/new")

	public ResponseEntity<List<Users>> createUser(@RequestBody Users users) {

		System.out.println("Data" + users);
		Userservice.save(users);
		return new ResponseEntity<>((List<Users>) Userservice.findAll(), HttpStatus.CREATED);
	}

	// Update user by Id
	@PutMapping("/edit/{id}")

	public ResponseEntity<Users> updateUser(@PathVariable("id") Long id,
			@RequestBody Users users) {
		Optional<Users> userOptional = Userservice.findById(id);
		return (ResponseEntity<Users>) userOptional.map(users1 -> {
			users.setId_user(users1.getId_user());
			return new ResponseEntity<>(Userservice.save(users), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	// Delete User
	@DeleteMapping("/delete/{id}")

	public ResponseEntity<List<Users>> delete(@PathVariable long id) {
		Userservice.delete(id);
		// Tra ve response voi STATUS CODE = 200 (OK)
		return new ResponseEntity<>((List<Users>) Userservice.findAll(), HttpStatus.OK);
	}

}
