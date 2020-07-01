package org.springframework.hshp;

/**
 * @ClassName StudentService
 * @Description TODO
 * @Author HX0011049
 * @Date 2019/11/22 15:08
 */
public class StudentService {

	private String name;

	private Integer age;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
