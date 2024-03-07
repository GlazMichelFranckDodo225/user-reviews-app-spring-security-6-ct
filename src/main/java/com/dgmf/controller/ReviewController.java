package com.dgmf.controller;

import com.dgmf.dto.ReviewDtoRequest;
import com.dgmf.dto.ReviewDtoResponse;
import com.dgmf.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    // Create Review REST API
    @PostMapping
    public ResponseEntity<ReviewDtoResponse> createReview(
            @RequestBody ReviewDtoRequest reviewDtoRequest
    ) {
        return new ResponseEntity<>(
                reviewService.createReview(reviewDtoRequest),
                HttpStatus.CREATED
        );
    }
}
