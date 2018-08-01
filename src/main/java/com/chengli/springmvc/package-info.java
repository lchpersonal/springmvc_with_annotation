/**
 * @Author: chengli
 * @Date: 2018/8/1 12:45
 * spring mvc 纯注解开发
 *  springmvc纯注解开发，依赖于servlet3.0提供的新特性，servlet3.0提供了一个ServletContainerInitializer接口，容器启动的时候会
 *  加载META-INF/services/javax.servlet.ServletContainerInitializer配置文件中配置的类，从而初始化容器。详情看：
 * @link https://github.com/lchpersonal/servlet3_with_annotation
 *
 * spring mvc的纯注解开发也是依赖于这个新特性
 * 在spring-web包 有一个同样的配置文件：/META-INF/services/javax.servlet.ServletContainerInitializer
 * 其中配置信息为：
 * @see org.springframework.web.SpringServletContainerInitializer
 * 该类加载了：WebApplicationInitializer接口，该接口就是我们注册spring mvc用到的接口。
 * @see com.chengli.springmvc.env.MyWebApplicationInitalizer 该类是springMvc的配置类，它继承AbstractAnnotationConfigDispatcherServletInitializer
 * AbstractAnnotationConfigDispatcherServletInitializer是实现了WebApplicationInitializer接口的抽象类，给我们封装了一些其他的组件。
 *
 *
 */
package com.chengli.springmvc;