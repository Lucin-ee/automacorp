package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.WindowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WindowDao extends JpaRepository<WindowEntity, Long>, WindowDaoCustom {
}