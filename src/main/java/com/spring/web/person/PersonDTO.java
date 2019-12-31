package com.spring.web.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

//이 클래스는 json 과 통신하기 위해 필요하다.

@Data
@Component
@Lazy
public class PersonDTO {
	
	private Long id;
	private String userid;
	private String passwd;
	private String name;
	private Date birthday;
	private String gender;
	private int hak;
	private int ban;
	private int score;
	private String role;

}
