package dw.gameshop.repository;

import dw.gameshop.model.Review;
import dw.gameshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}