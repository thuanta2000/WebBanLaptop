package vn.vku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WebLaptopApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebLaptopApplication.class, args);
    }

}
