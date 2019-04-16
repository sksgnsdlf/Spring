package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		//BeanFactory factory = new BeanFactory();
		
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}
}
