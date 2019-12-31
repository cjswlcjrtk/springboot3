package com.spring.web.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.util.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonCotroller {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Printer printer;	
	@Autowired private Person person;
	@Autowired ModelMapper modelMapper;
	
	@Bean
	public ModelMapper modelMapper() { return new ModelMapper();}
	
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getName() + " "));
		return sb.toString();
	}
	
	@PostMapping("/login")
	public HashMap<String, Object> login(@RequestBody Person param) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		printer.accept("로그인 진입");
		printer.accept(String.format("USERID : %s", param.getUserid()));
		printer.accept(String.format("PASSWD : %s", param.getPasswd()));
		person = personRepository.
				findByUseridAndPasswd(param.getUserid(), param.getPasswd());
		if(person != null) {
			printer.accept("로그인 성공");
			map.put("result", "SUCCESS");
			map.put("person", person);
			printer.accept(map.get("result"));
		}else {
			printer.accept("로그인 실패");
			map.put("result", "FAIL");
			map.put("person", person);
		}
		return map;
	}
	
	@DeleteMapping("/withdrawal/{userid}")
	public void withdrawal(@PathVariable String userid) {
		printer.accept("회원 탈퇴");
//		person = personRepository.findByUserid(userid);
//		personRepository.delete(person);
		personRepository.delete(personRepository.findByUserid(userid));
	}
	
	@GetMapping("/students")
	public List<PersonDTO> list(){ //jpa의 entity를 자바의  pojo로 전환
		printer.accept("list");
		Iterable<Person> entites = personRepository.findAll();
//		Iterable<Person> entites=personRepository.findByRole("student");
		
		List<PersonDTO> list = new ArrayList<>();
		for(Person p: entites) {
			PersonDTO dto = modelMapper.map(p, PersonDTO.class); // 내부적으로 for each가 돈다.
			list.add(dto);
		}
		
//		List<PersonDTO> studentList = list.stream().filter(s->s.getRole().equals("student")).collect(Collectors.toList());
//		printer.accept("list count::" + list.size());
//		printer.accept("studentList count::" + studentList.size());
		return list.stream().filter(s->s.getRole().equals("student")).collect(Collectors.toList());
	}
	
	@GetMapping("/students/{searchWord}")
	public List<PersonDTO> findSome(@PathVariable String searchWord){ 
		switch(searchWord) {
			case "namesOfStudents" : break;
			case "streamToArray" : break;
			case "streamToMap" : break;
			case "theNumberOfStudents" : break;
			case "totalScore" : break;
			case "topStudent" : break;
			case "getStat" : break;
			case "nameList" : break;
			case "partioningBy" : break;
			case "partioningCountPerGender" : break;
			case "partioningTopPerGender" : break;
			case "partioningRejectPerGender" : break;
			case "groupingByBan" : break;
			case "groupingByGrade" : break;
			case "groupingByCountByLevel" : break;
			case "groupingByHakAndBan" : break;
			case "groupingTopByHakAndBan" : break;
			case "groupingByStat" : break;
		}
		Iterable<Person> entites = personRepository.findGroupByHak();
		List<PersonDTO> list = new ArrayList<>();
		for(Person p: entites) {
			PersonDTO dto = modelMapper.map(p, PersonDTO.class);
			list.add(dto);
		}		
		return list.stream().filter(s->s.getRole().equals("student")).collect(Collectors.toList());
	}
	
	
}
