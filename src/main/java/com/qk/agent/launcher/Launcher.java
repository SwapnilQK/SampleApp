package com.qk.agent.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.qk.agent.RtaAgentApplication;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.qk")
public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RtaAgentApplication launcher = new RtaAgentApplication();
		launcher.start(args);
	}
	
	public void start(String[] args) {
		SpringApplication.run(Launcher.class, args);
		
	}

}