package com.cleevio.warehouse.web.impl;

import com.cleevio.warehouse.exceptions.EntityNotFoundException;
import com.cleevio.warehouse.service.WatchService;
import com.cleevio.warehouse.web.WatchController;
import com.cleevio.warehouse.web.model.WatchCmdDTO;
import com.cleevio.warehouse.web.model.WatchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class WatchControllerImpl implements WatchController {
    private final WatchService watchService;

    @Override
    public void create(@Valid WatchCmdDTO watchCmdDTO) {
        watchService.create(watchCmdDTO);
    }

    @Override
    public WatchDTO getOneById(Long id) {
        try {
            return watchService.getOneById(id);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Entity with id %d was not found!", id), ex);
        }
    }

    @Override
    public Page<WatchDTO> getAll(Pageable pageable) {
        return watchService.getAll(pageable);
    }

    @Override
    public void deleteOneById(Long id) {
        try {
            watchService.deleteOneById(id);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Entity with id %d was not found!", id), ex);
        }
    }
}
