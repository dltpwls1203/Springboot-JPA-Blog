package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


// @Getter
// @Setter
@Data // getter, setter
@NoArgsConstructor // 빈 생성자
//@AllArgsConstructor // 생성자
// @RequiredArgsConstructor
public class Member {
	private int id;
	private  String username;
	private  String password;
	private  String email;
	
	//@AllArgsConstructor
	@Builder
	public Member(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}	
}
