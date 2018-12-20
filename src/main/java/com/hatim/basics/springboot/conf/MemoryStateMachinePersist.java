package com.hatim.basics.springboot.conf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

import com.hatim.basics.springboot.conf.StateMachineConfig.Events;
import com.hatim.basics.springboot.conf.StateMachineConfig.States;

@Configuration
public class MemoryStateMachinePersist implements StateMachinePersist<States, Events, String>{

	Map<String, StateMachineContext<States, Events>> data = new HashMap<>();
	
	@Override
	public void write(StateMachineContext<States, Events> context, String contextObj) throws Exception {
		data.put(contextObj, context);
	}

	@Override
	public StateMachineContext<States, Events> read(String contextObj) throws Exception {
		return data.get(contextObj);
	}

	@Bean
	public StateMachinePersister<States, Events, String> getPersister() {
		return new DefaultStateMachinePersister<>(this);
	}
	
}
