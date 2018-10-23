package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Videos;
import com.codehard.miscursos.repositories.VideosReporitory;

@Service("servicioVideos")
public class VideosServiceImp {
	@Autowired
	@Qualifier("videosRepository")
	public VideosReporitory videosRepository;

	public Optional<Videos> getVideosById(Integer id) {
		return videosRepository.findById(id);
	}

	public List<Videos> getVideosAll() {
		return videosRepository.findAll();
	}

	public Videos addVideos(Videos videos) {
		return videosRepository.saveAndFlush(videos);
	}

	public Videos editVideos(Videos videos) {
		return videosRepository.saveAndFlush(videos);
	}

	public void deleteVideos(Integer id) {
		videosRepository.deleteById(id);
	}
}
