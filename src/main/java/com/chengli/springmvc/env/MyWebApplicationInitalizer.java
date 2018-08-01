package com.chengli.springmvc.env;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Author: chengli
 * @Date: 2018/8/1 13:26
 * springMvc配置类，该类实现了WebApplicationInitializer接口，封装了springMvc的常用配置，把需要自定义的信息暴露给用户。
 *
 * 该类，相当于之前web.xml中配置的以下信息：
 * <pre>
 *      <web-app>
 *           <listener>
 *               <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
 *           </listener>
 *
 *           <context-param>
 *                 <param-name>contextConfigLocation</param-name>
 *                 <param-value>/WEB-INF/app-context.xml</param-value>
 *           </context-param>
 *
 *           <servlet>
 *               <servlet-name>app</servlet-name>
 *               <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
 *               <init-param>
 *                     <param-name>contextConfigLocation</param-name>
 *                     <param-value></param-value>
 *               </init-param>
 *               <load-on-startup>1</load-on-startup>
 *          </servlet>
 *
 *          <servlet-mapping>
 *              <servlet-name>app</servlet-name>
 *               <url-pattern>/app/*</url-pattern>
 *          </servlet-mapping>
 * </web-app>
 * <pre/>
 */

public class MyWebApplicationInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * 根容器配置，包括所有的service和repository等组件
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootConfig.class
        };
    }

    /**
     * 子容器配置，包括所有的controller，试图解析器等
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                AppConfig.class
        };
    }

    /**
     *  '/'表示拦截所有请求，包括静态资源，但是不包括jsp
     *  '/*' 表示拦截所有请求，包括jsp
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


}
