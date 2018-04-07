package cn.morethink;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.morethink")
@MapperScan("cn.morethink.dao")
public class XssApplication {

	public static void main(String[] args) {
		SpringApplication.run(XssApplication.class, args);
	}
}
