package org.springframework.hshp;

/**
 * @ClassName Animal
 * @Description TODO
 * @Author HX0011049
 * @Date 2019/11/21 11:05
 */
public class Animal {

	private Cat cat;

	private Dog dog;

	private String remark;

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Animal() {
	}

	public Animal(Cat cat, Dog dog, String remark) {
		this.cat = cat;
		this.dog = dog;
		this.remark = remark;
	}

	public Animal(Cat cat, Dog dog) {
		this.cat = cat;
		this.dog = dog;
	}
}
