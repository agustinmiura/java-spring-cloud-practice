package ar.com.miura.limitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class LimitsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsserviceApplication.class, args);
	}

}
