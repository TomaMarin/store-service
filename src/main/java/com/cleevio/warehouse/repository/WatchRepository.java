package com.cleevio.warehouse.repository;

import com.cleevio.warehouse.repository.model.Watch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchRepository extends JpaRepository<Watch, Long> {
}
