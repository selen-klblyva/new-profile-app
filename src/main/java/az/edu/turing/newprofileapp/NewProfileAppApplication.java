package az.edu.turing.newprofileapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class NewProfileAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewProfileAppApplication.class, args);

         log.info("Project has started successfully!");

    }
}
