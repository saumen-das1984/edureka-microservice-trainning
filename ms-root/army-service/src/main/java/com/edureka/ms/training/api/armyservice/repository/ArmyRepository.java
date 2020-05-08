package com.edureka.ms.training.api.armyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edureka.ms.training.api.armyservice.model.Army;

@Repository
public interface ArmyRepository extends JpaRepository<Army, Long> {

}
