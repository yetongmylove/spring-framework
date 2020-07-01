package org.springframework.hshp;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author HX0011049
 * @Date 2019/11/21 11:22
 */
public class Dog {

	private String name;

	private Integer age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Dog(String name) {
		this.name = name;
	}

	public Dog(Integer age) {
		this.age = age;
	}

	public Dog(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Dog() {
	}
}
