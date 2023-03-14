package pack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import other.OutFileInterImpl;

@Configuration
public class Config {
	public MyInfo myInfo() {
		return new MyInfo();
	}
	@Bean("mImpl")
	public MessageImpl messageImpl() {
		MessageImpl impl = new MessageImpl("관우", "장비", 2000, myInfo());
		impl.setSpec("네트워크 전문가");
		impl.setFileInter(outFileInterImpl());
		return impl;
	}
	
	public OutFileInterImpl outFileInterImpl() {
		OutFileInterImpl fileInterImpl = new OutFileInterImpl();
		fileInterImpl.setFilePath("c:/work2/nice2.txt");
		return fileInterImpl;
	}
}
