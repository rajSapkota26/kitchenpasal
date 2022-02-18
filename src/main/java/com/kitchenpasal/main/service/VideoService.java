package com.kitchenpasal.main.service;

import com.kitchenpasal.main.model.VideoFile;

public interface VideoService {
	public boolean saveVideo(VideoFile videoFile);
	public boolean deleteVideo(VideoFile vidoFile);
}
