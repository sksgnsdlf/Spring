package com.springbook.biz.file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		
		//폴더목록조회
		File dir = new File("D:\\eclipse\\eclipse");
		File[] list = dir.listFiles();
		for(int i=0; i<list.length; i++) {
			File f = list[i];
			if(f.isDirectory()){ //폴더인지 확인하는것
				System.out.println("[" + f.getName() + "]");  //폴더방식이면 [___]처럼 나옴
			}else {
				System.out.println(f.getName() + " " +        //아닌것은 그냥나옴
								   f.length()/1024 + " " +  //파일크기
								   f.lastModified());		  //마지막수정날짜
			}
			System.out.println();
		}
		//파일정보확인(생성일자.,크기..)
		
		//파일생성
		File newFile = new File("C:\\Temp\\sample.txt");
		//newFile.createNewFile();   			//throws로 예외처리
		
		//폴더생성
		File newDir = new File("C:\\Temp","data");
		//newDir.mkdir();
		
		//파일삭제
		newFile.delete();		//빈파일 삭제
		
		//폴더삭제
		newDir.delete();
		
	}
}
