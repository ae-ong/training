package pack.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pack.model.DataDaoImpl;

@Configuration
public class Config { //환경설정 목적의 클래스(xml을 대신할 클래스)
	/*
	public DataDaoImpl dataDaoImpl() {
		DataDaoImpl dataDaoImpl = new DataDaoImpl();
		return dataDaoImpl;
	}
	@Bean
	public SelectServiceImpl selectServiceImpl() { //bean객체 생성
		SelectServiceImpl selectServiceImpl = new SelectServiceImpl(dataDaoImpl());
		return selectServiceImpl;
	}
	*/
	
	@Bean
	public DataDaoImpl dataDaoImpl() {
		return new DataDaoImpl();
	}
	
	@Bean
	public SelectServiceImpl selectServiceImpl(DataDaoImpl dataDaoImpl) {
		return new SelectServiceImpl(dataDaoImpl);
	}
}
