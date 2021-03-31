package com.benasselmeier.redhawkrentals.models.data;
import com.benasselmeier.redhawkrentals.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
