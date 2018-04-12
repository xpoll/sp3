/*
 * Copyright 2002-2009 the original author or authors.
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

package org.springframework.context;

/**
 * Interface defining methods for start/stop lifecycle control.
 * The typical use case for this is to control asynchronous processing.
 *
 * <p>Can be implemented by both components (typically a Spring bean defined in
 * a Spring {@link org.springframework.beans.factory.BeanFactory}) and containers
 * (typically a Spring {@link ApplicationContext}). Containers will propagate
 * start/stop signals to all components that apply.
 *
 * <p>Can be used for direct invocations or for management operations via JMX.
 * In the latter case, the {@link org.springframework.jmx.export.MBeanExporter}
 * will typically be defined with an
 * {@link org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler},
 * restricting the visibility of activity-controlled components to the Lifecycle
 * interface.
 *
 * <p>Note that the Lifecycle interface is only supported on <b>top-level singleton beans</b>.
 * On any other component, the Lifecycle interface will remain undetected and hence ignored.
 * Also, note that the extended {@link SmartLifecycle} interface provides more sophisticated
 * integration with the container's startup and shutdown phases.
 *
 * @author Juergen Hoeller
 * @since 2.0
 * @see SmartLifecycle
 * @see ConfigurableApplicationContext
 * @see org.springframework.jms.listener.AbstractMessageListenerContainer
 * @see org.springframework.scheduling.quartz.SchedulerFactoryBean
 * 
 * 接口定义了启动/停止生命周期的控制方法。典型的用例是控制异步处理。
 * 
 * 可以由两个组件（通常是Spring org.springframework.beans.factory.BeanFactory中定义的Spring bean）和容器（通常是Spring ApplicationContext）实现。 容器会将启动/停止信号传播给所有适用的组件。
 * 可以用于直接调用或通过JMX进行管理操作。 在后一种情况下，org.springframework.jmx.export.MBeanExporter通常会使用org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler进行定义，从而将活动控制组件的可见性限制到Lifecycle接口。
 * 请注意，生命周期接口仅在顶级单例bean上受支持。 在任何其他组件上，生命周期界面将保持未检测到，因此被忽略。 另外，请注意，扩展的SmartLifecycle界面提供了与容器的启动和关闭阶段的更复杂的集成。
 */
public interface Lifecycle {

	/**
	 * Start this component.
	 * Should not throw an exception if the component is already running.
	 * <p>In the case of a container, this will propagate the start signal
	 * to all components that apply.
	 */
	void start();

	/**
	 * Stop this component, typically in a synchronous fashion, such that
	 * the component is fully stopped upon return of this method. Consider
	 * implementing {@link SmartLifecycle} and its {@code stop(Runnable)}
	 * variant in cases where asynchronous stop behavior is necessary.
	 * <p>Should not throw an exception if the component isn't started yet.
	 * <p>In the case of a container, this will propagate the stop signal
	 * to all components that apply.
	 * @see SmartLifecycle#stop(Runnable)
	 */
	void stop();

	/**
	 * Check whether this component is currently running.
	 * <p>In the case of a container, this will return <code>true</code>
	 * only if <i>all</i> components that apply are currently running.
	 * @return whether the component is currently running
	 */
	boolean isRunning();

}
