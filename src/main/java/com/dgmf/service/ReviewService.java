package com.dgmf.service;

import com.dgmf.dto.ReviewDtoRequest;
import com.dgmf.dto.ReviewDtoResponse;

public interface ReviewService {
    ReviewDtoResponse createReview(ReviewDtoRequest reviewDtoRequest);
}
