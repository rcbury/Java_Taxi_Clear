package org.example.service;

import org.example.dto.CarDto;
import org.example.dto.DriverDto;
import org.example.interfaces.CarRepositoryInterface;
import org.example.interfaces.DriverRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    DriverRepositoryInterface repository;

    DriverService(DriverRepositoryInterface repository) {
        this.repository = repository;
    }

    public DriverDto create(DriverDto driverDto) {
        return repository.create(driverDto);
    }
    public void delete(Long id) {
        repository.delete(id);
    }
    public DriverDto getById(Long id) {
        return repository.getById(id);
    }
    public DriverDto update(DriverDto driverDto) {
        return repository.update(driverDto);
    }

    public List<DriverDto> getAll() {
        return repository.getAll();
    }
}
