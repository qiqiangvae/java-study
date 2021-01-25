package org.example.dubbo.common.api;

import java.util.List;

/**
 * @author qiqiang
 * @date 2020-11-24 10:56 上午
 */
public interface BookApi {
    List<String> findByAuthor(String author);
}