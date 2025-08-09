package uz.pdp.omnborxona.repository.impl;

import jakarta.enterprise.context.ApplicationScoped;
import uz.pdp.omnborxona.model.entity.Warehouse;
import uz.pdp.omnborxona.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class WarehouseRepositoryImpl implements WarehouseRepository {
    @Override
    public Optional<Warehouse> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Warehouse> findAll() {
        return List.of();
    }

    @Override
    public Warehouse save(Warehouse entity) {
        return null;
    }

    @Override
    public void delete(Warehouse entity) {

    }
}
