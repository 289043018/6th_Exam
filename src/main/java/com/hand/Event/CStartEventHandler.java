package com.hand.Event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;
@Component
public class CStartEventHandler implements ApplicationListener<ContextStartedEvent>{
	public void onApplicationEvent(ContextStartedEvent event){
		System.out.println("Context Start");
	}
}
