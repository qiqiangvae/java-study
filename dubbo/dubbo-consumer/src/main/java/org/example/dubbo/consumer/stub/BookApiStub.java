package org.example.dubbo.consumer.stub;

import org.example.dubbo.common.api.BookApi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiqiang
 * @date 2020-12-01 13:57
 */
public class BookApiStub implements BookApi {
    private final BookApi bookApi;

    public BookApiStub(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public List<String> findByAuthor(String author) {
        // 此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
        System.out.println("参数校验");
        try {
            return bookApi.findByAuthor(author);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}