package pack.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pack.model.SangpumImpl;

@Configuration
public class Config {
	public SangpumImpl sangpumImpl() {
		SangpumImpl sangpumImpl = new SangpumImpl();
		return sangpumImpl;
	}
	@Bean
	public MyImpl myImpl() {
		MyImpl myImpl = new MyImpl(sangpumImpl());
		return myImpl;
	}
}
