package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserContainer {

	public static void main(String[] args) {
		//컨테이너 구동 -> 설정파일에 등록된 빈을 생성해서 컨테이너에 담아준다.
		AbstractApplicationContext  factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		//컨테이너에 객체 요청
		TV tv = (TV)factory.getBean("tv"); //tv를 주입받고 연관(의존)성이 있는 객체도 주입(injection)
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		
		//컨테이너 종료
		factory.close();
		
		//		tv.powerOn();
//		TV tv2 = (TV)factory.getBean("tv");
//		tv2.powerOn();
//		TV tv3 = (TV)factory.getBean("tv");
//		tv3.powerOn();
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
	}
}
