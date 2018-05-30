package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication
{
	public static void run(Class<?> config, String[] args) {
		AnnotationConfigApplicationContext myContext =
				new AnnotationConfigApplicationContext(config);
		
		myContext.getBeanFactory().createBean(AppConsole.class).run(args);
		
		myContext.close();
	}
}