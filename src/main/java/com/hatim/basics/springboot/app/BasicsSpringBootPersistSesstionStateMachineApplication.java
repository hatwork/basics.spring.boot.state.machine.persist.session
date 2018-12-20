package com.hatim.basics.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.hatim.basics.springboot") 	
public class BasicsSpringBootPersistSesstionStateMachineApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BasicsSpringBootPersistSesstionStateMachineApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		
		//Start the statemachine... 
		stateMachine.start();
		
		System.out.println("State machine is started.");
		
		System.out.println("START event invoked..");
		
		stateMachine.sendEvent(SampleEvent.START);
		
		System.out.println("CREATE event invoked..");
		
		stateMachine.sendEvent(SampleEvent.CRETAE);
		
		System.out.println("CLOSE event invoked..");
		
		stateMachine.sendEvent(SampleEvent.CLOSE);
		
		State<SampleState, SampleEvent> state = stateMachine.getState();
		
		System.out.println("HATIM => 'BasicsSpringBootStateMachineApplication.commandLineRunner' State :: " +  state );
		
		return null;
	}*/
	
}
