package cn.morethink;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "cn.morethink")
@MapperScan("cn.morethink.dao")
@ServletComponentScan(basePackages = "cn.morethink.filter")
public class SQLInjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SQLInjectionApplication.class, args);
	}
}
