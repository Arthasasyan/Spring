package com.example2.demo2.dao;

import com.example2.demo2.entity.HumanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanEntityRepositroy extends JpaRepository<HumanEntity, Long> {
}
