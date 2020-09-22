package com.dunn;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BeanFactory Approach 
//Step 1. creating a Resources which contains the information of the beans
		Resource resource = new ClassPathResource("applicationContext.xml");
//Step 2.Create a bean factory for the resource		
		BeanFactory beanFactory = new XmlBeanFactory(resource);//Deprecated
//		call the getBean() to get the instance 
		Coach c = (Coach) beanFactory.getBean("myCoach");
		System.err.println("Using Bean Factory"+c.getDailyWorkout());
//		ApplicationContext Approiach
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach c1 = (Coach) applicationContext.getBean("myCoach");
		Coach c2 = (Coach) applicationContext.getBean("trackCoach");
		System.out.println(c1.getDailyWorkout());
		System.out.println(c2.getDailyWorkout());

		applicationContext.close();
		
		
		
	}

}
