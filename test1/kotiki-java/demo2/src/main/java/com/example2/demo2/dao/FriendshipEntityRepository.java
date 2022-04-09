package com.example2.demo2.dao;

import com.example2.demo2.entity.FriendshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendshipEntityRepository extends JpaRepository<FriendshipEntity, Long> {
}