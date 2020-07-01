package org.wecancodeit.reviewsitefullstack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsitefullstack.models.Review;
import org.wecancodeit.reviewsitefullstack.repositories.ReviewRepository;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class ReviewController {

    @Resource
    private ReviewRepository reviewRepo;

    @RequestMapping("/reviews")
    public String displayReviews(Model model) {
        model.addAttribute("reviews", reviewRepo.findAll());
        return "reviewsView";
    }

    @RequestMapping("/reviews/{id}")
    public String displaySingleReview(@PathVariable long id, Model model) {
        Optional<Review> retrievedReview = reviewRepo.findById(id);
        Review foundReview = retrievedReview.get();
        model.addAttribute("review", foundReview);
        return "reviewView";
    }
}