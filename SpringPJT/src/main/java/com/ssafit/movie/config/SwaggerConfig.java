package com.ssafit.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("SSAFIT First PJT")
	              .description("Specialist Team [ANSMOON / KTH]")
	              .version("v0.0.1")
	              .license(new License().name("lab.ssafy.com").url("https://lab.ssafy.com/s11/b04/chain-pjt/-/tree/master/6_Spring_0426/12%ED%8C%80_%EA%B9%80%ED%83%9C%ED%95%9C%EB%8B%98_%EB%AC%B8%EB%B2%94%EC%88%98%EB%8B%98?ref_type=heads")));
	  }
}
