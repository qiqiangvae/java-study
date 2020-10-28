package org.example.spring.validation;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author qiqiang
 * @date 2020-10-22 6:20 下午
 */
public class BookBO2VOConverterFactory implements ConverterFactory<BookBO, BookVO> {
    @Override
    public <T extends BookVO> Converter<BookBO, T> getConverter(Class<T> targetType) {
        return null;
    }

    static class BookBO2VOConverter implements Converter<BookBO, BookVO> {

        @Override
        public BookVO convert(BookBO source) {
            BookVO bookVO = new BookVO();
            bookVO.setName(source.getName());
            return bookVO;
        }
    }
}