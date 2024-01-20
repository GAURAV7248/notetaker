package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
//	variable
	 public static SessionFactory factory;
//	method 
	 public static SessionFactory getFactory()
	 {
		 if (factory==null)
		 {
//			 create factory  configuration object call method configure
			 factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			 
		 }
		 return factory;
		 
	 }
	 
//	 method
	 public void closeFactory()
	 {
		 if(factory.isOpen())
		 {
			 factory.close();
		 }
	 }
	 

}
