package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.Rating;
import org.atsynthesizer.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
