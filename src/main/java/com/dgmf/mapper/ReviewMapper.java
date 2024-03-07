package com.dgmf.mapper;

import com.dgmf.dto.ReviewDtoRequest;
import com.dgmf.dto.ReviewDtoResponse;
import com.dgmf.entity.Review;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewMapper {
    private final ModelMapper modelMapper;

    public Review mapToEntity(ReviewDtoRequest reviewDtoRequest) {
        Review review = modelMapper.map(reviewDtoRequest, Review.class);

        return review;
    }

    public ReviewDtoResponse mapToDto(Review review) {
        ReviewDtoResponse reviewDtoResponse =
                modelMapper.map(review, ReviewDtoResponse.class);

        return reviewDtoResponse;
    }
}
