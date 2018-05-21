package com.web;

import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@SpringBootApplication
public class SpringConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConsumerApplication.class, args);
		boolean s=true;
		while (s) {
			Scanner name=new Scanner(System.in);
			System.out.println("Please Enter Method Name : ");
			String methodName=name.nextLine();
		switch(methodName) {
		case "test" :
				test();
				break;
		case "get" :
			get();
			break;
		case "post" :
			post();
			break;
		case "delete" :
			delete();
			break;
		case "put" :
			put();
			break;
		}
		s=methodName.equalsIgnoreCase("exit")?false:true;
		continue;
		}
		System.out.println("thanks");
	}

	private static void test() {
		Client client=Client.create();
		String url="http://localhost:2022/";
		WebResource resource=client.resource(url);
		ClientResponse clientResponse=(ClientResponse) resource.get(ClientResponse.class);
		String msg=(String) clientResponse.getEntity(String.class);
		System.out.println(msg);
	}
	public static void get() {
		Client client=Client.create();
		String url="http://10.10.0.98:2022/truck/1/details";
		WebResource web=client.resource(url);
		ClientResponse response=web.header("token", "5").get(ClientResponse.class);
		String message=response.getEntity(String.class);
		System.out.println(message);
	}
	public static void post() {
		Client client=Client.create();
		String url="http://localhost:2022/registration";
		String data="{\"truckDriverName\": \"jagan\",\"truckDriverAddress\":\"gwl\",\"truckDriverContact\": \"236\"}";
		WebResource web=client.resource(url);
		ClientResponse response=web.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, data);
		String message=response.getEntity(String.class);
		System.out.println(message);
	}
	public static void delete() {
		Client client=Client.create();
		String url="http://localhost:2022/clear?driverId=4";
		WebResource web=client.resource(url);
		ClientResponse response=web.delete(ClientResponse.class);
		String message=response.getEntity(String.class);
		System.out.println(message);
	}
	public static void put() {
		Client client=Client.create();
		String url="http://localhost:2022/edit";
		String data="{\"truckDriverId\":\"6\",\"truckDriverName\": \"jagan\",\"truckDriverAddress\":\"gwl\",\"truckDriverContact\": \"236\"}";
		WebResource web=client.resource(url);
		ClientResponse response=web.type(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class, data);
		String message=response.getEntity(String.class);
		System.out.println(message);
	}

}
