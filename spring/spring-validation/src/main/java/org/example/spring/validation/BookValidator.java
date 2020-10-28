package org.example.spring.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * @author qiqiang
 * @date 2020-10-22 5:29 下午
 */
public class BookValidator implements Validator {
    private BigDecimal lowPrice = new BigDecimal("10");
    private BigDecimal highPrice = new BigDecimal("100");

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "书名为空");
        ValidationUtils.rejectIfEmpty(errors, "publicationDate", "出版日期为空");
        Book book = (Book) target;
        if (book.getPrice().compareTo(lowPrice) < 0) {
            errors.rejectValue("price", "定价太低");
        } else if (book.getPrice().compareTo(highPrice) > 0) {
            errors.rejectValue("price", "定价太高");
        }
    }
}