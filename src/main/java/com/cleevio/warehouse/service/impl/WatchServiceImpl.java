package com.cleevio.warehouse.service.impl;

import com.cleevio.warehouse.exceptions.EntityNotFoundException;
import com.cleevio.warehouse.repository.WatchRepository;
import com.cleevio.warehouse.service.WatchService;
import com.cleevio.warehouse.web.model.WatchCmdDTO;
import com.cleevio.warehouse.web.model.WatchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class WatchServiceImpl implements WatchService {
    private final WatchRepository watchRepository;

    @Override
    public void create(WatchCmdDTO watchCmdDTO) {
        watchRepository.save(watchCmdDTO.mapToEntity());
    }

    @Override
    public WatchDTO getOneById(Long id) throws EntityNotFoundException {
        return new WatchDTO(watchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Product with id %d was not found!", id))));
    }

    @Override
    public Page<WatchDTO> getAll(Pageable pageable) {
        return watchRepository.findAll(pageable).map(WatchDTO::new);
    }

    @Override
    public void deleteOneById(Long id) throws EntityNotFoundException {
        watchRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Product with id %d was not found!", id)));
        watchRepository.deleteById(id);
    }
}
