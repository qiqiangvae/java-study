package org.example.dubbo.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.dubbo.common.api.BookApi;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

/**
 * @author qiqiang
 * @date 2020-11-24 10:58 上午
 */
@SpringBootApplication
public class DubboConsumerApplication implements ApplicationRunner {
    @DubboReference(cache = "lru", stub = "org.example.dubbo.consumer.stub.BookApiStub")
    private BookApi bookApi;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> books = bookApi.findByAuthor("");
        System.out.println(books);
        books = bookApi.findByAuthor("");
        System.out.println(books);
    }
}