package com.iu.s5.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	//1. 폴더 생성
	//2. 저장할 파일명 생성
	//3. 파일 HDD 저장
	
	
	//1. fileCopyUtils 클래스 사용
	public String saveByUtils(MultipartFile file, String path) throws Exception{
		//폴더가 있는지 없는지부터 확인
		//자바내에서 파일의 정보 저장하는 객체 > File
		File f = new File(path);	// 이 경로에 대한 파일의 정보 저장
		System.out.println(f.exists()); //폴더가 없어서 false 뜬다
		//없으면 디렉토리를 만들어준다
		if(!f.exists()) {
			//resources/memberUpload
			//resources/upload/member
			//f.mkdir();	//
			f.mkdirs();	//부모폴더까지 만들고 싶을 때. 경로명이 어찌 올지 모르니 이걸 쓰겟음
		}
		
		//a. 파일명 생성
		String fileName = this.makeNameByUUID(file.getOriginalFilename());
		
		f = new File(f, fileName);
		//b. HDD에 저장
		FileCopyUtils.copy(file.getBytes(), f);
		
		
		
		return fileName;
	}
	
	
	
	//2. MultipartFile
	public String saveByTransfer(MultipartFile file, String path)throws Exception{
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String fileName = this.makeNameByUUID(file.getOriginalFilename());
		
		f= new File(f, fileName);
		
		file.transferTo(f);
		
		return fileName;
		
	}
	
	
	
	//3. OutputStream  //잘안씀
	public String saveByStream(MultipartFile file, String path) throws Exception{
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String fileName = this.makeNameByUUID(file.getOriginalFilename());
		
		f = new File(f, fileName);
		
		
		FileOutputStream fs = new FileOutputStream(f);
		fs.write(file.getBytes());
		fs.close();
		
		
		return fileName;
	}
	
	
	
	//파일명 생성해주는 메서드 - 두 개 중 아무거나 써두 댐
	
	private String makeNameByUUID(String name) {
		String result = UUID.randomUUID().toString();
		result = result + "_" + name;
		return result;
	}

	

	private String makeNameByTime(String name) {
		Calendar ca = Calendar.getInstance();
		Long l = ca.getTimeInMillis();
		System.out.println(name);
		
		String result = name.substring(0, name.indexOf("."));
		result = result+"_"+l+".";
		result = result+name.substring(name.lastIndexOf("."));
		
		System.out.println(result);
		
		
		
		System.out.println(name);
		return result;
	}
	///////////////////////////////////////////////////////////////

	
	
	
	//fileDelete
	public int deleteFile(String fileName, String path) throws Exception{
		
		File file = new File(path, fileName);
		boolean check=false;
		int result=0;
		if(file.exists()) {
			check = file.delete();
		}
		if(check) {
			result=1;
		}
		
		return result;
		
		
	}
	
	
	
}
