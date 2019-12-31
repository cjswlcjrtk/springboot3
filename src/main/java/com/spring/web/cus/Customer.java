package com.spring.web.cus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
@Table(name="CUSTOMER")
public class Customer {
//	private String cno,
//	cemail,
//	cpwd,
//	cname,
//	cntcd,		// 고객 국가 코드
//	cphone,
//	cstcd,		// 고객상태코드
//	sdate,		// 가입일
//	wdate,		// 탈퇴일
//	udate;		// 수정일

	/*	private String 
	  CNO, CEMAIL, CPWD, CNAME, CNTCD, 
	  CPHONE, CSTCD, SDATE, WDATE, UDATE;		*/
	
	@Id
	@GeneratedValue
	@Column(name="CNO", nullable=false)
	private String cno;
	@Column(name="CEMAIL", nullable=false)
	private String cemail;
	@Column(name="CPWD", nullable=false)
	private String cpwd;
	@Column(name="CNAME", nullable=false)
	private String cname;
	@Column(name="CNTCD", nullable=false)
	private String cntcd;
	@Column(name="CPHONE", nullable=false)
	private String cphone;
	@Column(name="CSTCD", nullable=false)
	private String cstcd;
	@Column(name="SDATE", nullable=false)
	private String sdate;
	@Column(name="WDATE", nullable=false)
	private String wdate;
	@Column(name="UDATE", nullable=false)
	private String udate;

	
}