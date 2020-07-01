package org.wecancodeit.reviewsitefullstack.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewsitefullstack.models.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findCategoryByGenre(String genre);


}

