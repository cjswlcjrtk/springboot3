package com.spring.web.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.spring.web.proxy.Proxy;

@Component
public class PersonInit extends Proxy implements ApplicationRunner{
	private PersonRepository personRepository;
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	public PersonInit(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = personRepository.count();
		if(count == 0) {
			Person person = null;
			String[][] mtx = {{"hong","1","홍길동","1980-01-01","true","0","0","0","teacher"},
					{"kim","1","김유신","1980-05-05","true","0","0","0","manager"},
					{"park","1","박지성1","1980-06-05","true","0","0","0","manager"},
					{"park1","1","박지성2","1980-06-05","true","1","3","20","student"},
					{"park2","1","박지성3","1980-06-05","true","2","3","20","student"},
					{"park3","1","박지성4","1980-06-05","true","2","3","60","student"},
					{"park4","1","박지성5","1980-06-05","true","4","4","50","student"},
					{"park5","1","박지성6","1980-06-05","true","3","3","80","student"},
					{"park6","1","박지성7","1980-06-05","true","4","2","40","student"},
					{"park7","1","박지성8","1980-06-05","true","3","1","20","student"},
					{"park8","1","박지성9","1980-06-05","true","2","3","80","student"},
					{"park9","1","박지성0","1980-06-05","true","1","3","20","student"},
					{"you","1","유관순1","1980-09-09","false","2","4","90","student"},
					{"you1","1","유관순2","1980-09-09","false","2","4","60","student"},
					{"you2","1","유관순3","1980-09-09","false","3","1","30","student"},
					{"you3","1","유관순4","1980-09-09","false","4","1","20","student"},
					{"you4","1","유관순5","1980-09-09","false","2","3","60","student"},
					{"you5","1","유관순6","1980-09-09","false","3","2","60","student"},
					{"you6","1","유관순7","1980-09-09","false","2","3","40","student"},
					{"you7","1","유관순8","1980-09-09","false","1","4","30","student"},
					{"you8","1","유관순9","1980-09-09","false","1","4","30","student"},
					{"you9","1","유관순0","1980-09-09","false","1","4","90","student"}};
			for(String[] arr : mtx) {
				person = new Person();				
				person.setUserid(arr[0]);
				person.setPasswd(arr[1]);
				person.setName(arr[2]);
				person.setBirthday(df.parse(arr[3]));
				person.setMale(Boolean.parseBoolean(arr[4]));
				person.setHak(Integer.parseInt(arr[5]));
				person.setBan(Integer.parseInt(arr[6]));
				person.setScore(Integer.parseInt(arr[7]));				
				person.setRole(arr[8]);
				personRepository.save(person);
			}
//			for(int i=0; i<mtx.length; i++) {
//				person = new Person();
//				person.setUserid(mtx[i][0]);
//				person.setPasswd(mtx[i][1]);
//				person.setName(mtx[i][2]);
//				person.setBirthday(df.parse(mtx[i][3]));
//				personRepository.save(person);								
//			}
		}
	}
}
