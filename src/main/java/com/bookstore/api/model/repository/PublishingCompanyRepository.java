package com.bookstore.api.model.repository;

import com.bookstore.api.model.entity.PublishingCompany;
import com.bookstore.api.model.vo.PublishingCompanyVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PublishingCompanyRepository extends JpaRepository<PublishingCompany, Long> {
    @Query("select new com.bookstore.api.model.vo.PublishingCompanyVO(p) from PublishingCompany p where p.id = :publishingId")
    Optional<PublishingCompanyVO> findPublishingById(Long publishingId);
}
