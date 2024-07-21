package com.application.rest.service.impl;

import com.application.rest.controllers.dto.MakerDTO;
import com.application.rest.entities.Maker;
import com.application.rest.persistence.IMakerDAO;
import com.application.rest.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MakerServiceImpl implements IMakerService {
    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public List<Maker> findAll() {
        return makerDAO.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDAO.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerDAO.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerDAO.deleteById(id);
    }

    @Override
    public MakerDTO toDTO(Maker maker) {
        return MakerDTO.builder()
                .id(maker.getId())
                .name(maker.getName())
                .productList(maker.getProductList())
                .build();
    }
    @Override
    public Maker fromDTO(MakerDTO makerDTO) {
        return Maker.builder()
                .name(makerDTO.getName())
                .build();
    }
    @Override
    public List<MakerDTO> toDTOList(List<Maker> makers) {
        return makers.stream().map(this::toDTO).collect(Collectors.toList());
    }
    @Override
    public ResponseEntity<?> saveMaker(MakerDTO makerDTO) throws URISyntaxException {
        if (makerDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Maker maker = fromDTO(makerDTO);
        save(maker);
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }
    @Override
    public ResponseEntity<?> updateMaker(Long id, MakerDTO makerDTO) {
        Optional<Maker> makerOptional = findById(id);
        if (makerOptional.isPresent()) {
            Maker maker = makerOptional.get();
            maker.setName(makerDTO.getName());
            save(maker);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

}
