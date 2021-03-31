package com.benasselmeier.redhawkrentals.models.data;
import com.benasselmeier.redhawkrentals.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {
}
