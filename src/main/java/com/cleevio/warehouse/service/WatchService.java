package com.cleevio.warehouse.service;

import com.cleevio.warehouse.web.model.WatchCmdDTO;
import com.cleevio.warehouse.web.model.WatchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WatchService {
    void create(WatchCmdDTO watchCmdDTO);

    WatchDTO getOneById(Long id);

    Page<WatchDTO> getAll(Pageable pageable);

    void deleteOneById(Long id);
}
