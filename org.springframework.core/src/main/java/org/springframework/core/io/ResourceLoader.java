/*
 * Copyright 2002-2007 the original author or authors.
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

package org.springframework.core.io;

import org.springframework.util.ResourceUtils;

/**
 * Strategy interface for loading resources (e.. class path or file system
 * resources). An {@link org.springframework.context.ApplicationContext}
 * is required to provide this functionality, plus extended
 * {@link org.springframework.core.io.support.ResourcePatternResolver} support.
 *
 * <p>{@link DefaultResourceLoader} is a standalone implementation that is
 * usable outside an ApplicationContext, also used by {@link ResourceEditor}.
 *
 * <p>Bean properties of type Resource and Resource array can be populated
 * from Strings when running in an ApplicationContext, using the particular
 * context's resource loading strategy.
 *
 * @author Juergen Hoeller
 * @since 10.03.2004
 * @see Resource
 * @see org.springframework.core.io.support.ResourcePatternResolver
 * @see org.springframework.context.ApplicationContext
 * @see org.springframework.context.ResourceLoaderAware
 * 
 * 加载资源策略的接口，一个{@link org.springframework.context.ApplicationContext}需要此功能，
 * 并加以扩展{@link org.springframework.core.io.support.ResourcePatternResolver}支持
 * 
 * {@link DefaultResourceLoader} 是一个独立的可在ApplicationContext外部使用的实现，也可以由{@link ResourceEditor}使用
 * 
 * 在ApplicationContext中运行时，使用特定上下文的资源加载策略，可以从Strings中填充Resource和Resource数组类型的Bean属性。
 */
public interface ResourceLoader {

	/** Pseudo URL prefix for loading from the class path: "classpath:" */
	String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;


	/**
	 * Return a Resource handle for the specified resource.
	 * The handle should always be a reusable resource descriptor,
	 * allowing for multiple {@link Resource#getInputStream()} calls.
	 * <p><ul>
	 * <li>Must support fully qualified URLs, e.g. "file:C:/test.dat".
	 * <li>Must support classpath pseudo-URLs, e.g. "classpath:test.dat".
	 * <li>Should support relative file paths, e.g. "WEB-INF/test.dat".
	 * (This will be implementation-specific, typically provided by an
	 * ApplicationContext implementation.)
	 * </ul>
	 * <p>Note that a Resource handle does not imply an existing resource;
	 * you need to invoke {@link Resource#exists} to check for existence.
	 * @param location the resource location
	 * @return a corresponding Resource handle
	 * @see #CLASSPATH_URL_PREFIX
	 * @see org.springframework.core.io.Resource#exists
	 * @see org.springframework.core.io.Resource#getInputStream
	 * 
	 * 返回指定资源的资源句柄。 该句柄应始终是可重用的资源描述符，允许多个Resource.getInputStream（）调用。
	 * 必须支持完全限定的网址，例如“文件：C：/test.dat”。
	 * 必须支持类路径伪网址，例如“类路径：TEST.DAT”。
	 * 应该支持相对文件路径，例如“WEB-INF/ TEST.DAT”。 （这将是特定于实现的，通常由ApplicationContext实现提供。）
	 * 请注意，资源句柄并不意味着现有资源; 你需要调用Resource.exists来检查是否存在。
	 */
	Resource getResource(String location);

	/**
	 * Expose the ClassLoader used by this ResourceLoader.
	 * <p>Clients which need to access the ClassLoader directly can do so
	 * in a uniform manner with the ResourceLoader, rather than relying
	 * on the thread context ClassLoader.
	 * @return the ClassLoader (never <code>null</code>)
	 * 
	 * 公开此ResourceLoader使用的ClassLoader。
	 * 需要直接访问ClassLoader的客户端可以使用ResourceLoader以统一的方式执行此操作，而不是依赖线程上下文ClassLoader。
	 */
	ClassLoader getClassLoader();

}
