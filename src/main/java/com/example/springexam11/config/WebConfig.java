package com.example.springexam11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//스프링 설정
@Configuration //Spring Java Config
@EnableWebMvc // <mvc:annotation-driven />
//com.example 패키지 하위에서 @Controller가 붙은 클래스를 다 Bean으로 등록해달라.
@ComponentScan(basePackages = {"com.example"},
               includeFilters = {@ComponentScan.Filter(Controller.class) })
public class WebConfig implements WebMvcConfigurer {
    public WebConfig() {
        System.out.println("webConfig가 실행됩니다.");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        System.out.println("configureDefaultServletHandling이 실행됩니다.");
        configurer.enable(); //디폴트 서블릿을 사용하도록 설정.
    }

    // 스프링에서 JSP를 사용하려면 ViewResolver를 설정하라. InternalResourceViewResolver가 필요하다.
    // InternnalResourceViewResolver를 Bean으로 등록하라.
    // /WEB-INF/view/ + "hello" + ".jsp"
    // jsp는 url을 통하여 직접 접근할 수 있다.
    //Controller를 통해서만 접근할 수 있도록 한다.
    @Bean
    public InternalResourceViewResolver getInternalReourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
