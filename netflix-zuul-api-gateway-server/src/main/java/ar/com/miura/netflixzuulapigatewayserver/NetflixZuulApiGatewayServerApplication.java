package ar.com.miura.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}

	/**
	 *
	 * @return
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
