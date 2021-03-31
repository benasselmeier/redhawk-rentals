package com.benasselmeier.redhawkrentals.models.data;

import com.benasselmeier.redhawkrentals.models.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {

    List<Equipment> findByNameContaining(String name);

}
