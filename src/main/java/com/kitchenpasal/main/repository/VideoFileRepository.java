package com.kitchenpasal.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kitchenpasal.main.model.VideoFile;

public interface VideoFileRepository extends JpaRepository<VideoFile, String>{

}
