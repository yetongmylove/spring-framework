/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.framework;

import org.springframework.aop.SpringProxy;

import java.io.Serializable;
import java.lang.reflect.Proxy;

/**
 * Default {@link AopProxyFactory} implementation, creating either a CGLIB proxy
 * or a JDK dynamic proxy.
 *
 * <p>Creates a CGLIB proxy if one the following is true for a given
 * {@link AdvisedSupport} instance:
 * <ul>
 * <li>the {@code optimize} flag is set
 * <li>the {@code proxyTargetClass} flag is set
 * <li>no proxy interfaces have been specified
 * </ul>
 *
 * <p>In general, specify {@code proxyTargetClass} to enforce a CGLIB proxy,
 * or specify one or more interfaces to use a JDK dynamic proxy.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 12.03.2004
 * @see AdvisedSupport#setOptimize
 * @see AdvisedSupport#setProxyTargetClass
 * @see AdvisedSupport#setInterfaces
 */
@SuppressWarnings("serial")
/*默认情况下 proxy-target-class 属性为 false。当目标 bean 实现了接口时，Spring 会基于 JDK 动态代理为目标 bean 创建代理对象。
若未实现任何接口，Spring 则会通过 CGLIB 创建代理。而当 proxy-target-class 属性设为 true 时，则会强制 Spring 通过 CGLIB 的方式创建代理对象，即使目标 bean 实现了接口*/
public class DefaultAopProxyFactory implements AopProxyFactory, Serializable {

	@Override
	public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
		/*
		 *   1.proxy-target-class没有配置或者proxy-target-class="false"，返回JdkDynamicAopProxy
		 *   2.proxy-target-class="true"或者<bean>对象没有实现任何接口或者只实现了SpringProxy接口，返回Cglib2AopProxy
		 */


		/*	1.ProxyConfig的isOptimize方法为true，这表示让Spring自己去优化而不是用户指定
		 *  2.ProxyConfig的isProxyTargetClass方法为true，这表示配置了proxy-target-class="true"
		 *  3.ProxyConfig满足hasNoUserSuppliedProxyInterfaces方法执行结果为true，这表示<bean>对象没有实现任何接口或者实现的接口是SpringProxy接口
		*/
		if (config.isOptimize()
                || config.isProxyTargetClass()
                || hasNoUserSuppliedProxyInterfaces(config)) {
			Class<?> targetClass = config.getTargetClass();
			if (targetClass == null) {
				throw new AopConfigException("TargetSource cannot determine target class: " +
						"Either an interface or a target is required for proxy creation.");
			}
            // 使用 JDK 代理策略
            if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
				return new JdkDynamicAopProxy(config);
			}
            // 使用 CGLIB 代理策略
            return new ObjenesisCglibAopProxy(config);
		} else {
            // 使用 JDK 代理策略
            return new JdkDynamicAopProxy(config);
		}
	}

	/**
	 * Determine whether the supplied {@link AdvisedSupport} has only the
	 * {@link org.springframework.aop.SpringProxy} interface specified
	 * (or no proxy interfaces specified at all).
	 */
	private boolean hasNoUserSuppliedProxyInterfaces(AdvisedSupport config) {
		Class<?>[] ifcs = config.getProxiedInterfaces();
		return (ifcs.length == 0 || (ifcs.length == 1 && SpringProxy.class.isAssignableFrom(ifcs[0])));
	}

}