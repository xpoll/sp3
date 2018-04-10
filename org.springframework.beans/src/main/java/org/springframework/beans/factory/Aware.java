/*
 * Copyright 2002-2011 the original author or authors.
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
 * Marker superinterface indicating that a bean is eligible to be
 * notified by the Spring container of a particular framework object
 * through a callback-style method.  Actual method signature is
 * determined by individual subinterfaces, but should typically
 * consist of just one void-returning method that accepts a single
 * argument.
 *
 * <p>Note that merely implementing {@link Aware} provides no default
 * functionality. Rather, processing must be done explicitly, for example
 * in a {@link org.springframework.beans.factory.config.BeanPostProcessor BeanPostProcessor}.
 * Refer to {@link org.springframework.context.support.ApplicationContextAwareProcessor}
 * and {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory}
 * for examples of processing {@code *Aware} interface callbacks.
 *
 * @author Chris Beams
 * @since 3.1
 * 
 * 标记超级接口，表示一个bean有资格通过一个回调式方法被Spring容器通知一个特定的框架对象。 实际的方法签名由各个子接口确定，但通常应由一个只接受一个参数的void返回方法组成。
 * 请注意，仅实现Aware不提供默认功能。 相反，处理必须明确完成，例如在BeanPostProcessor中。
 * 有关处理* Aware接口回调的示例，
 * 请参阅
 * org.springframework.context.support.ApplicationContextAwareProcessor
 * 和
 * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory。
 * 
 */
public interface Aware {

}
