package dw.gameshop.dto;

import dw.gameshop.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ReviewDto {
    private long gameId;

    private String gameName;

    private String userId;

    private int reviewPoint;

    private String reviewText;


    // Review Entity를 Review DTO로 변환
    // 이런 식의 형변환 코드를 내장하는 것이 효율적이다.
    public ReviewDto toReviewDtoFromReview(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setReviewPoint(review.getPoint());
        reviewDto.setReviewText(review.getReviewText());
        reviewDto.setGameId(review.getGame().getId());
        reviewDto.setGameName(review.getGame().getTitle());
        reviewDto.setUserId(review.getUser().getUserId());

        return reviewDto;
    }

    // Review Dto를 Review Entity로 형변환


}