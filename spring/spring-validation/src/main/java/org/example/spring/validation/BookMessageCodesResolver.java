package org.example.spring.validation;

import org.springframework.validation.MessageCodesResolver;

/**
 * @author qiqiang
 * @date 2020-10-22 5:55 下午
 */
public class BookMessageCodesResolver implements MessageCodesResolver {
    @Override
    public String[] resolveMessageCodes(String errorCode, String objectName) {
        return new String[0];
    }

    @Override
    public String[] resolveMessageCodes(String errorCode, String objectName, String field, Class<?> fieldType) {
        return new String[]{"1", "2", "3"};
    }
}