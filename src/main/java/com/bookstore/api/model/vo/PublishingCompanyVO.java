package com.bookstore.api.model.vo;

import com.bookstore.api.model.entity.PublishingCompany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class PublishingCompanyVO {

    private Long id;
    private String name;
    private OffsetDateTime createdDate;

    public PublishingCompanyVO(PublishingCompany publishingCompany) {
        id = publishingCompany.getId();
        name = publishingCompany.getName();
        createdDate = publishingCompany.getCreatedDate();
    }
}
