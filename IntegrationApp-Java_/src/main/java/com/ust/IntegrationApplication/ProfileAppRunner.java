package com.ust.IntegrationApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.ust.vo.Employee;
import com.ust.vo.Salary;

public class ProfileAppRunner {
	
	public static void main(String arhs[]){
		
		try{
		saveEmployee();
		saveSalary();
		}catch(Exception ex){
			System.out.println("******* The error " + ex);
		}
		
	}
	
	public static MongoOperations getMongoOperation(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoDBConfig.class);
		MongoOperations mongo= (MongoOperations) ctx.getBean("mongoTemplate");
		return mongo;
	}
	
	public static void saveEmployee(){
		 MongoOperations mongo= getMongoOperation();	
		 Employee emp = new Employee("1002", "Raj", 2000);
		 mongo.save(emp);
	}
	
	public static void saveSalary(){
		MongoOperations mongo= getMongoOperation();
		 Salary sal = new Salary(1010, 200, 111);
		 mongo.save(sal);
	}
	
}
