package com.ty.online_event_management_web_app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class EventManagmentConfig {

	
	
	public Docket getDocket() {
		Contact contact = new Contact("TY", "www.tetyanra.com", "testyantrasupport@mail.com");
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("online_event_managment App", "online event management App V1.0", "Version 1.2",
				"www.testyantraglobal.com", contact, "testYtantralicence@asdf", "www.testyantraterms.com", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.online_event_management_web_app")).build()
				.apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
	
	
}
