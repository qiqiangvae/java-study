package org.example.spring.aop;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return defaultPointcutAdvisor;
    }
}