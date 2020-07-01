package org.wecancodeit.reviewsitefullstack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wecancodeit.reviewsitefullstack.models.Category;
import org.wecancodeit.reviewsitefullstack.models.Review;
import org.wecancodeit.reviewsitefullstack.repositories.CategoryRepository;
import org.wecancodeit.reviewsitefullstack.repositories.ReviewRepository;

import java.util.Collection;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWritingTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ReviewRepository reviewRepo;

    @Test
    public void t1categoryShouldHaveAListOfReviews() {
        Category testCategory = new Category("Test Genre");
        Category testCategory2 = new Category("Test Genre2");
        Review testReview = new Review("Title", "Image", "Content", testCategory);
        Review testReview2 = new Review("Title", "Image", "Content", testCategory2);

        categoryRepo.save(testCategory);
        categoryRepo.save(testCategory2);
        reviewRepo.save(testReview);
        reviewRepo.save(testReview2);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoryOpt = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOpt.get();
        Review retrievedReview = reviewRepo.findById(testReview.getId()).get();
        assertThat(retrievedCategory.getReviews()).contains(testReview);

    }


}
