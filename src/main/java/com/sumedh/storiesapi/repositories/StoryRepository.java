package com.sumedh.storiesapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sumedh.storiesapi.entities.Story;

@Transactional
@Repository
public interface StoryRepository extends JpaRepository<Story, Integer> {

}
