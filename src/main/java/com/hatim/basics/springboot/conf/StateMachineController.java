package com.hatim.basics.springboot.conf;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hatim.basics.springboot.conf.StateMachineConfig.Events;
import com.hatim.basics.springboot.conf.StateMachineConfig.States;

@Controller
public class StateMachineController {

	 @Autowired
	 private StateMachine<States, Events> stateMachine;

	@Autowired
	private StateMachinePersister<States, Events, String> persister;

	@RequestMapping("/")
	public String greeting() {
		return "redirect:/states";
	}

	@RequestMapping("/states")
	public String getStates(HttpSession session, @RequestParam(value = "event", required = false) Events event,
			Model model) {

		try {
			System.out.println(null != session ? session.getId() : "No-session");

			stateMachine = persister.restore(stateMachine, session.getId());
			persister.persist(stateMachine, session.getId());

			if (event != null) {
				if( stateMachine.sendEvent(event) ) {
					persister.persist(stateMachine, session.getId());
				}
			}

			model.addAttribute("states", stateMachine.getState().getIds());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "states";
	}

}