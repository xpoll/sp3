/*
 * Copyright 2002-2010 the original author or authors.
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

package org.springframework.beans.factory;

/**
 * Interface to be implemented by objects used within a {@link BeanFactory}
 * which are themselves factories. If a bean implements this interface,
 * it is used as a factory for an object to expose, not directly as a bean
 * instance that will be exposed itself.
 *
 * <p><b>NB: A bean that implements this interface cannot be used as a
 * normal bean.</b> A FactoryBean is defined in a bean style, but the
 * object exposed for bean references ({@link #getObject()} is always
 * the object that it creates.
 *
 * <p>FactoryBeans can support singletons and prototypes, and can
 * either create objects lazily on demand or eagerly on startup.
 * The {@link SmartFactoryBean} interface allows for exposing
 * more fine-grained behavioral metadata.
 *
 * <p>This interface is heavily used within the framework itself, for
 * example for the AOP {@link org.springframework.aop.framework.ProxyFactoryBean}
 * or the {@link org.springframework.jndi.JndiObjectFactoryBean}.
 * It can be used for application components as well; however,
 * this is not common outside of infrastructure code.
 *
 * <p><b>NOTE:</b> FactoryBean objects participate in the containing
 * BeanFactory's synchronization of bean creation. There is usually no
 * need for internal synchronization other than for purposes of lazy
 * initialization within the FactoryBean itself (or the like).
 * 
 * 
 * 
 * 接口由BeanFactory中使用的对象实现，这些对象本身就是工厂。如果一个bean实现了这个接口，它就被用作一个对象公开的工厂，而不是直接作为一个将被暴露的bean实例。
 * 
 * 注意：实现此接口的bean不能用作普通bean。 FactoryBean以bean风格定义，但为bean引用公开的对象（getObject()）始终是它创建的对象。
 * 
 * FactoryBeans可以支持单例和原型，并可以根据需要或在启动时急切地创建对象。 SmartFactoryBean接口允许公开更多细粒度的行为元数据。
 * 
 * 这个接口在框架本身中大量使用，例如用于AOP org.springframework.aop.framework.ProxyFactoryBean或org.springframework.jndi.JndiObjectFactoryBean。
 * 它也可以用于应用程序组件;但是，这在基础架构代码之外并不常见。
 * 
 * 注意：FactoryBean对象参与包含BeanFactory的bean创建同步。除了FactoryBean本身（或诸如此类）内的惰性初始化之外，通常不需要内部同步。
 * 
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 08.03.2003
 * @see org.springframework.beans.factory.BeanFactory
 * @see org.springframework.aop.framework.ProxyFactoryBean
 * @see org.springframework.jndi.JndiObjectFactoryBean
 */
public interface FactoryBean<T> {

	/**
	 * Return an instance (possibly shared or independent) of the object
	 * managed by this factory.
	 * <p>As with a {@link BeanFactory}, this allows support for both the
	 * Singleton and Prototype design pattern.
	 * <p>If this FactoryBean is not fully initialized yet at the time of
	 * the call (for example because it is involved in a circular reference),
	 * throw a corresponding {@link FactoryBeanNotInitializedException}.
	 * <p>As of Spring 2.0, FactoryBeans are allowed to return <code>null</code>
	 * objects. The factory will consider this as normal value to be used; it
	 * will not throw a FactoryBeanNotInitializedException in this case anymore.
	 * FactoryBean implementations are encouraged to throw
	 * FactoryBeanNotInitializedException themselves now, as appropriate.
	 * @return an instance of the bean (can be <code>null</code>)
	 * @throws Exception in case of creation errors
	 * @see FactoryBeanNotInitializedException
	 */
	T getObject() throws Exception;

	/**
	 * Return the type of object that this FactoryBean creates,
	 * or <code>null</code> if not known in advance.
	 * <p>This allows one to check for specific types of beans without
	 * instantiating objects, for example on autowiring.
	 * <p>In the case of implementations that are creating a singleton object,
	 * this method should try to avoid singleton creation as far as possible;
	 * it should rather estimate the type in advance.
	 * For prototypes, returning a meaningful type here is advisable too.
	 * <p>This method can be called <i>before</i> this FactoryBean has
	 * been fully initialized. It must not rely on state created during
	 * initialization; of course, it can still use such state if available.
	 * <p><b>NOTE:</b> Autowiring will simply ignore FactoryBeans that return
	 * <code>null</code> here. Therefore it is highly recommended to implement
	 * this method properly, using the current state of the FactoryBean.
	 * @return the type of object that this FactoryBean creates,
	 * or <code>null</code> if not known at the time of the call
	 * @see ListableBeanFactory#getBeansOfType
	 */
	Class<?> getObjectType();

	/**
	 * Is the object managed by this factory a singleton? That is,
	 * will {@link #getObject()} always return the same object
	 * (a reference that can be cached)?
	 * <p><b>NOTE:</b> If a FactoryBean indicates to hold a singleton object,
	 * the object returned from <code>getObject()</code> might get cached
	 * by the owning BeanFactory. Hence, do not return <code>true</code>
	 * unless the FactoryBean always exposes the same reference.
	 * <p>The singleton status of the FactoryBean itself will generally
	 * be provided by the owning BeanFactory; usually, it has to be
	 * defined as singleton there.
	 * <p><b>NOTE:</b> This method returning <code>false</code> does not
	 * necessarily indicate that returned objects are independent instances.
	 * An implementation of the extended {@link SmartFactoryBean} interface
	 * may explicitly indicate independent instances through its
	 * {@link SmartFactoryBean#isPrototype()} method. Plain {@link FactoryBean}
	 * implementations which do not implement this extended interface are
	 * simply assumed to always return independent instances if the
	 * <code>isSingleton()</code> implementation returns <code>false</code>.
	 * @return whether the exposed object is a singleton
	 * @see #getObject()
	 * @see SmartFactoryBean#isPrototype()
	 */
	boolean isSingleton();

}
