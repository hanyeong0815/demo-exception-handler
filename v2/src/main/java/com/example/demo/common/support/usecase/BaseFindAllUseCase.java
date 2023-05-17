package com.example.demo.common.support.usecase;

import org.springframework.data.domain.Pageable;

public interface BaseFindAllUseCase<T> {
    Iterable<T> findAll();
    Iterable<T> findAll(Pageable pageable);
}
