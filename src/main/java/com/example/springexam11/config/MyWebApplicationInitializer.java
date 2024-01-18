package com.example.springexam11.config;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //한글이 깨지지 않도록 설정 - 필터설정
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[]{encodingFilter};
    }

    // 스프링 컨테이너 --- 웹과 관련된 설정(Spring MVC - getServletConfigClasses), 비지니스로직과 관련된 설정(트랜잭션, DB프로그래밍 - getRootConfigClasses)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

//   옛날 방식
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        System.out.println("onStartup이 실행됩니다.");
//
//        // Load Spring web application configuration
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(WebConfig.class, AppConfig.class);
//
//        // Create and register the DispatcherServlet
//        DispatcherServlet servlet = new DispatcherServlet(context);
//        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcherServlet", servlet);
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//    }
}
