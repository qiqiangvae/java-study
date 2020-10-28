package org.example.spring.validation;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qiqiang
 * @date 2020-10-22 5:29 下午
 */
public class Book {
    private String name;
    private BigDecimal price;
    private Date publicationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}