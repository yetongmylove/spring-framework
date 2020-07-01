package org.springframework.hshp;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName MyFactoryBean
 * @Description TODO
 * @Author HX0011049
 * @Date 2019/11/21 11:35
 */
public class MyFactoryBean implements FactoryBean<Dog> {

	@Override
	public Dog getObject() throws Exception {
		return new Dog("myDog", 88);
	}

	@Override
	public Class<?> getObjectType() {
		return Dog.class;
	}
}
