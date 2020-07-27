package spring.jpa.separate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.jpa.separate.controller.response.BaseResponse;

@RestController
@RequestMapping("system")
public class SystemController {
	
	@Autowired
	private ApplicationContext applicationContext;

	@GetMapping(value = "/bean/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BaseResponse getBean() 
	{
		String[] appContextBeans = applicationContext.getBeanDefinitionNames();
		return new BaseResponse(appContextBeans);
	}
	
}
