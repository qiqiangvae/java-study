package org.example.spring.aop;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author qiqiang
 */
@Configuration
public class AopConfig {
    @Bean
    public DefaultPointcutAdvisor pointcutAdvisor() {
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        ExampleInterceptor interceptor = new ExampleInterceptor();
        defaultPointcutAdvisor.setAdvice(interceptor);
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("hello");
        defaultPointcutAdvisor.setPointcut(pointcut);
//        defaultPointcutAdvisor.setPointcut(new AnnotationMatchingPointcut(Service.class, Override.class, false));
        return defaultPointcutAdvisor;
    }
}