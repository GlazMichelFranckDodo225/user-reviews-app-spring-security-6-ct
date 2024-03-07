package com.dgmf.service.impl;

import com.dgmf.dto.ReviewDtoRequest;
import com.dgmf.dto.ReviewDtoResponse;
import com.dgmf.entity.Review;
import com.dgmf.mapper.ReviewMapper;
import com.dgmf.repository.ReviewRepository;
import com.dgmf.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewDtoResponse createReview(ReviewDtoRequest reviewDtoRequest) {
        Review savedReview =
                reviewRepository.save(reviewMapper.mapToEntity(reviewDtoRequest));

        ReviewDtoResponse reviewDtoResponse = reviewMapper.mapToDto(savedReview);

        return reviewDtoResponse;
    }
}
