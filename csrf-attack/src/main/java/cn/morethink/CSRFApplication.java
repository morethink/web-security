package cn.morethink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.morethink")

public class CSRFApplication {

    public static void main(String[] args) {
        SpringApplication.run(CSRFApplication.class, args);
    }
}
