package com.app.api.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rests")
public class RestCliController {
	
	// ======= GET =======
	
	// GET METHOD for files XML and JSON
	@GetMapping("/gets")
	private static String getEmployeesGet() {
		
	    final String uri = "https://reqres.in/api/users?page=2";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result); 
	    
	    return result;
	    
	}
	
	/*
	 // GET METHOD for files XML and JSON with get for entity
	@GetMapping("/gets")
	private static ResponseEntity<String> getEmployeesGet() {
		
	    final String uri = "https://reqres.in/api/users?page=2";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    System.out.println(result); 
	    
	    return result;
	    
	}*/
	
	
	// Saca la informacion con las cabeceras
	@GetMapping("/headers")
	private static String getEmployeesHttp() {
		
	    final String uri = "https://reqres.in/api/users?page=2";
	     
	    RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	     
	    System.out.println(result);
	    
		return uri;
	    
	}
	
	// Saca la informacion como un objeto
	@GetMapping("/objects")
	private static void getEmployeesObjects() {
		
	    final String uri = "https://reqres.in/api/users?page=2";
	    RestTemplate restTemplate = new RestTemplate();
	     
	    EmployeeListVO result = restTemplate.getForObject(uri, EmployeeListVO.class);
	     
	    System.out.println(result);
	    
	}
	
	// Saca la informacion con parametros url como un JSON
	@GetMapping("/urls")
	private static String getEmployeeById() {
		
	    final String uri = "https://reqres.in/api/users?page={page}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("page", "3");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class, params);
	     
	    System.out.println(result); 
	    return result;
	    
	}
	
	// ======= POST =======	
	
	@PostMapping("/posts")
	private static void createEmployee() {
		
	    final String uri = "https://reqres.in/api/users";
	 
	    EmployeeVO newEmployee = new EmployeeVO("Adam", "Gilly");
	 
	    RestTemplate restTemplate = new RestTemplate();
	    EmployeeVO result = restTemplate.postForObject( uri, newEmployee, EmployeeVO.class);
	 
	    System.out.println(result);
	    
	}
	
	// ======= PUT =======	
	@PutMapping("/puts")
	private static void updateEmployee() {
		
	    final String uri = "https://reqres.in/api/users?page={id}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "7");
	     
	    EmployeeVO updatedEmployee = new EmployeeVO("New Name", "Gilly");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.put ( uri, updatedEmployee, params);
	    
	}
	
	// ======= DELETED =======	
	
	@DeleteMapping("/deletes")
	private static void deleteEmployee() {
		
	    final String uri = "https://reqres.in/api/users?page={id}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "7");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.delete ( uri,  params );
	    
	}
	
}
