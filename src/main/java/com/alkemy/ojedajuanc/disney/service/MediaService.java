package com.alkemy.ojedajuanc.disney.service;

import java.util.List;
import java.util.Optional;

import com.alkemy.ojedajuanc.disney.domain.MediaBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaPostDTO;

public interface MediaService {

	List<MediaBasicDTO> getAll();

	Optional<MediaDTO> getMedia(Long id);

	MediaDTO createMedia(MediaPostDTO newMedia);

}
