package com.sapient.user.swagger;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import com.google.common.base.Predicate;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import static springfox.documentation.builders.PathSelectors.regex;
//import static com.google.common.base.Predicates.or;
//
//@Configuration
//@EnableWebMvc
//@EnableSwagger2
//public class SwaggerConfig {
//
//	@Bean
//	public Docket postsApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();
//	}
//
////	private Predicate<String> postPaths() {
////		//, regex("/api/javainuse.*")
////		return or(regex("/user-service.*"));
////	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder().title("User Service")
//				.description("GLM POC")
//				.termsOfServiceUrl("localhost:8081")
//				.contact("mallu.cs015@gmail.com").license("Not required")
//				.licenseUrl("mallu.cs015@gmail.com").version("1.0").build();
//	}
//}
