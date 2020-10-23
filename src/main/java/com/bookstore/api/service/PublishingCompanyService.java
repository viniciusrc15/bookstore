package com.bookstore.api.service;

import com.bookstore.api.exception.EntityNotFoundException;
import com.bookstore.api.model.entity.PublishingCompany;
import com.bookstore.api.model.enums.ErrorEnum;
import com.bookstore.api.model.repository.BookRepository;
import com.bookstore.api.model.repository.PublishingCompanyRepository;
import com.bookstore.api.model.vo.BookVO;
import com.bookstore.api.model.vo.PublishingCompanyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublishingCompanyService {

    public final PublishingCompanyRepository publishingCompanyRepository;
    public final BookRepository bookRepository;

    public PublishingCompany save(PublishingCompany publishingCompany) {
        return publishingCompanyRepository.save(publishingCompany);
    }

    public PublishingCompanyVO findById(Long id) {
        return publishingCompanyRepository.findPublishingById(id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorEnum.PUBLISHING_NOT_FOUND));
    }

    public List<BookVO> findBooksByPublishingId(Long publishingId){
        return bookRepository.findByPublishingCompanyId(publishingId);
    }

    public Page<PublishingCompany> findAll(int page, int size) {
        return publishingCompanyRepository.findAll(PageRequest.of(page,  size));
    }
}
