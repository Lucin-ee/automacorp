package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingDao extends JpaRepository<BuildingEntity, Long> {
    // Optionally, you can add custom query methods here if needed
}
