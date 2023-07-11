package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

	// http://localhost:8090/blog//temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// 파일리턴 기본경로 : src/main/resources/static
		// 리턴명 : /home.html 
		// -> home.html이면 src/main/resources/statichome.html 이다.
		return "/home.html";
	}

	@GetMapping("/temp/jsp")
	public String tempJsp() {
		return "test";
	}
	
}
