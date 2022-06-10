package com.edito.fundamentos;

import com.edito.fundamentos.bean.*;
import com.edito.fundamentos.component.ComponentDependency;
import com.edito.fundamentos.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private Clara clara;
	private BeanProperties beanProperties;
	private UserPojo pojo;




	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, Clara clara, BeanProperties beanProperties, UserPojo pojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.clara = clara;
		this.beanProperties = beanProperties;
		this.pojo = pojo;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}
	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println("-----------------------");
		clara.print();
		System.out.println("--------------------------");
		System.out.println(beanProperties.print());
		System.out.println("-------------------------------------");
		System.out.println(pojo.getEmail() + " " + pojo.getPassword());
		try{
			int value = 10/0;
		} catch (Exception e){
			LOGGER.error("Esto es un error al dividir por cero ");
		}
	}
}
