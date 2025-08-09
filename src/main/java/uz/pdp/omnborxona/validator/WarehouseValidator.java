package uz.pdp.omnborxona.validator;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uz.pdp.omnborxona.model.entity.Warehouse;
import uz.pdp.omnborxona.repository.WarehouseRepository;

@ApplicationScoped
public class WarehouseValidator {

    @Inject
    private WarehouseRepository repository;

    public Warehouse existsAndGet(String id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Warehouse with id " + id + " not found")
        );
    }
}
