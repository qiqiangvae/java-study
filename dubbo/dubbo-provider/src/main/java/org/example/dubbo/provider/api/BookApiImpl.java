package org.example.dubbo.provider.api;

import org.example.dubbo.common.api.BookApi;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author qiqiang
 * @date 2020-11-24 11:00 上午
 */
@DubboService(protocol = "hessian")
public class BookApiImpl implements BookApi {
    @Override
    public List<String> findByAuthor(String author) {
        List<String> books = new ArrayList<>();
        books.add("天龙八部");
        books.add("射雕英雄传");
        books.add("神雕侠侣");
        books.add(new Date().toString());
        return books;
    }
}