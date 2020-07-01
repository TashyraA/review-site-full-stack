package org.wecancodeit.reviewsitefullstack.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewsitefullstack.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
