package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv") //bean 등록 설정
public class SamsungTV implements TV{
	
	//@Autowired  //<property 이용한 객체 주입
	//@Qualifier("apple") //name , 중복이 확인되었을때 하나 지정하는것
	@Resource(name="apple")
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV 기본생성자");
	}
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("setSpeaker 호출");
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		System.out.println("setPrice 호출");
	}

	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("SamsungTV 객체 생성");
	}
	
	public SamsungTV(Speaker speaker, int price) {
		super();
		this.speaker = speaker;
		this.price = price;
		System.out.println("SamsungTV 객체 생성. price 초기화");
	}

	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}
	public void powerOff() {
		System.out.println("SamsungTV powerDown");
	}
	public void volumeUp() {
		//System.out.println("SamsungTV volumeUp");
		speaker.volumeUp();
	}
	public void volumeDown() {
		//System.out.println("SamsungTV volumeDown");
		speaker.volumeDown();
	}	
	
	public void initMethod() { //컨테이너에서 처음쓸때 무조건 불러와써지는것
		System.out.println("객체 초기화 작업 처리");
	}
	
	public void destroyMethod() { //컨테이너에서 로직을 닫을때 불러와써지는것
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
}
