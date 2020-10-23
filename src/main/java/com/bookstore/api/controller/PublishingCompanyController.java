package com.bookstore.api.controller;

import com.bookstore.api.model.entity.PublishingCompany;
import com.bookstore.api.model.vo.BookVO;
import com.bookstore.api.model.vo.PublishingCompanyVO;
import com.bookstore.api.service.PublishingCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/publishing-company")
@RequiredArgsConstructor
public class PublishingCompanyController {

    public final PublishingCompanyService publishingCompanyService;

    @PostMapping
    public ResponseEntity<PublishingCompany> save(@RequestBody PublishingCompany publishingCompany){
        return ResponseEntity.ok(publishingCompanyService.save(publishingCompany));
    }

    @GetMapping
    public ResponseEntity<Page<PublishingCompany>> findById(
            @RequestParam("page") int page, @RequestParam("size") int size){
        return ResponseEntity.ok(publishingCompanyService.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublishingCompanyVO> findById(@PathVariable Long id){
        return ResponseEntity.ok(publishingCompanyService.findById(id));
    }

    @GetMapping("/{id}/book")
    public ResponseEntity<List<BookVO>> findBooksByPublishingId(@PathVariable Long id){
        return ResponseEntity.ok(publishingCompanyService.findBooksByPublishingId(id));
    }

}
