package org.springframework.hshp;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author HX0011049
 * @Date 2019/11/21 11:06
 */
public class Cat {

	private String name;

	private Integer age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Cat(String name) {
		this.name = name;
	}

	public Cat(Integer age) {
		this.age = age;
	}

	public Cat(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Cat() {
	}
}
