package com.chengli.springmvc.env;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author: chengli
 * @Date: 2018/8/1 14:36
 * 其中@EnableWebMvc注解，是启用springMvc的高级定制功能【视图解析器，handlerMapping等】，相当于配置文件中的<mvc:annotation-driven/>
 * 实现WebMvcConfigurer接口，定制我们的所有高级功能，例如配置视图解析器等。（如果不需要配置，可以不使用该注解）。
 * 这里我们继承的WebMvcConfigurerAdapter是WebMvcConfigurer接口的实现类。
 */
@EnableWebMvc
@ComponentScan(basePackages = "com.chengli.springmvc.controller")
public class AppConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置静态资源，将springmvc处理不了的请求，交给Tomcat处理
     *  相当于xml配置中的 <mvc:default-servlet-handler/>,在springMVC-servlet.xml中配置<mvc:default-servlet-handler />后，
     *  会在Spring MVC上下文中定义一个org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler，
     *  它会像一个检查员，对进入DispatcherServlet的URL进行筛查，如果发现是静态资源的请求，就将该请求转由Web应用服务器默认的Servlet处理，
     *  如果不是静态资源的请求，才由DispatcherServlet继续处理。一般Web应用服务器默认的Servlet名称是"default"，
     *  因此DefaultServletHttpRequestHandler可以找到它。如果你所有的Web应用服务器的默认Servlet名称不是"default"，
     *  则需要通过default-servlet-name属性显示指定：<mvc:default-servlet-handler default-servlet-name="所使用的Web服务器默认
     *  使用的Servlet名称" />
     *
     *  注意： 这里的静态资源必须在web根路径下，不能放入WEB-INF路径下。
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 采用<mvc:resources />更进一步，由Spring MVC框架自己处理静态资源，并添加一些有用的附加值功能。
     * 首先，<mvc:resources />允许静态资源放在任何地方，如WEB-INF目录下、类路径下等，你甚至可以将JavaScript等静态文件打到JAR包中。
     * 通过location属性指定静态资源的位置，由于location属性是Resources类型，因此可以使用诸如"classpath:"等的资源前缀指定资源位置。
     * 传统Web容器的静态资源只能放在Web容器的根路径下，<mvc:resources />完全打破了这个限制。
     * 其次，<mvc:resources />依据当前著名的Page Speed、YSlow等浏览器优化原则对静态资源提供优化。
     * 你可以通过cacheSeconds属性指定静态资源在浏览器端的缓存时间，一般可将该时间设置为一年，以充分利用浏览器端的缓存。
     * 在输出静态资源时，会根据配置设置好响应报文头的Expires 和 Cache-Control值。在接收到静态资源的获取请求时，
     * 会检查请求头的Last-Modified值，如果静态资源没有发生变化，则直接返回303相应状态码，提示客户端使用浏览器缓存的数据，
     * 而非将静态资源的内容输出到客户端，以充分节省带宽，提高程序性能。
     *
     * 以下配置将Web根路径"/"及/WEB-INF/resources/的目录映射为/resources路径。现在/WEB-INF/resources/路径下有1.png，可以通过
     * /resources/1.png访问。
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/","/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/",".jsp");
    }


}
