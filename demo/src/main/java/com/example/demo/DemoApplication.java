package com.example.demo;

//packages associated with spring
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//decorators that initializes the springboot application and defines
//a restful api controller
@SpringBootApplication
@RestController
public class DemoApplication {

	// the num to be modified
	int num = 0;

	// starts the spring application
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	 * url: http://localhost:8080/
	 * returns the current value of num
	 */
	@GetMapping("/")
	public String displayNum() {
		return String.format("Number: %d", num);
	}

	/*
	 * url: http://localhost:8080/increment
	 * increases num's value by 1
	 */
	@GetMapping("/increment")
	public String increase() {
		num += 1;
		return String.format("Number incremented!");
	}

	/*
	 * url: http://localhost:8080/add?count=20
	 * increases num's value by the user
	 * inputted number
	 */
	@GetMapping("/add")
	public String vote(@RequestParam(value = "count", defaultValue = "0") String numString) {
		num += Integer.parseInt(numString);
		return String.format("Number increased by %s!", numString);
	}

}
