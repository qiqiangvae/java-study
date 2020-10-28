package org.example.spring.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qiqiang
 * @date 2020-10-22 5:29 下午
 */
public class ValidatorExample {
    public static void main(String[] args) {
        Book book = new Book();
        BeanWrapper beanWrapper = new BeanWrapperImpl(book);
        PropertyValue value = new PropertyValue("publicationDate", new Date());
        beanWrapper.setPropertyValue(value);
        book.setPrice(new BigDecimal(-1));
        BookValidator bookValidator = new BookValidator();
        DataBinder dataBinder = new DataBinder(book);
        dataBinder.setValidator(bookValidator);
        dataBinder.validate();
        BindingResult results = dataBinder.getBindingResult();
        for (ObjectError error : results.getAllErrors()) {
            System.out.println(error.getCode());
        }
    }
}