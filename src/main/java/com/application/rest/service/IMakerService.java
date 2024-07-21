package com.application.rest.service;

import com.application.rest.controllers.dto.MakerDTO;
import com.application.rest.entities.Maker;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

public interface IMakerService {
    List<Maker> findAll();
    Optional<Maker> findById(Long id);
    void save(Maker maker);
    void deleteById(Long id);

    MakerDTO toDTO(Maker maker);
    Maker fromDTO(MakerDTO makerDTO);
    List<MakerDTO> toDTOList(List<Maker> makers);

    ResponseEntity<?> saveMaker(MakerDTO makerDTO) throws URISyntaxException;
    ResponseEntity<?> updateMaker(Long id, MakerDTO makerDTO);
}
