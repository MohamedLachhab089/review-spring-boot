package com.stage24.review_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewSpringBootApplication {

	public static void main(String[] args) {
		// the commented part is in the default form
//		SpringApplication.run(ReviewSpringBootApplication.class, args);

//		Testing testing = new Testing();
//		System.out.println(testing.Hi());

		var ctx = SpringApplication.run(ReviewSpringBootApplication.class, args);
		// you can use this one
		/* Testing testing = ctx.getBean(Testing.class);
		System.out.println(testing.Hi() + " testing");
		// or this one (here we add & call method's name which is "testing")
		Testing testing1 = ctx.getBean("testing",Testing.class);
		System.out.println(testing1.Hi() + " testing 1"); */


		Testing testing = ctx.getBean("FirstTesting",Testing.class);
		System.out.println(testing.Hi() + " testing");
		// or this one (here we add & call method's name which is "testing")
		Testing testing1 = ctx.getBean("SecondTesting",Testing.class);
		System.out.println(testing1.Hi() + " testing 1");


		System.out.println("----------------------------------------------------");

		/* if you try this 2 ligne of code below without
		injection(with a constructor or @Autowired annotation) you'll get an error
		* java.lang.NullPointerException */
		FirstService firstService = ctx.getBean(FirstService.class);
		System.out.println(firstService.Message());


        /* after specifying your bean and choose which bean you gonna
        * execute, now there's the test */



	}

	// using bean
	/* if you want to use the bean without mention it "@Bean" you can use in the class
	* that u want to run "@Component", and then you can run your program without @Bean
	* furthermore if you ran your code without mention "@Component" you'll get an error
	* .NoSuchBeanDefinitionException remember that
	*
	* you can also use @Service or @Repository to run it as a Bean
	* but the most useful one is to use @Service */
	//@Bean
	public Testing testing(String var){
		return new Testing("hello everyone ==> var = " + var);
	}

}
