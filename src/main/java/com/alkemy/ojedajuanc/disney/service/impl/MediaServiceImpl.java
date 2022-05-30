package com.alkemy.ojedajuanc.disney.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.ojedajuanc.disney.domain.MediaBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaDTO;
import com.alkemy.ojedajuanc.disney.mapper.MediaMapper;
import com.alkemy.ojedajuanc.disney.persistence.repository.MediaRepository;
import com.alkemy.ojedajuanc.disney.service.MediaService;

@Service
public class MediaServiceImpl implements MediaService {
	
	@Autowired
	MediaRepository repository;
	@Autowired
	MediaMapper mapper;

	@Override
	public List<MediaBasicDTO> getAll() {
		return mapper.toListBasicDTO(repository.findAll());
	}

	@Override
	public Optional<MediaDTO> getMedia(Long id) {
		return repository.findById(id).map(media -> mapper.toDTO(media));
	}

}
