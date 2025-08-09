package uz.pdp.omnborxona.service;

import uz.pdp.omnborxona.mapper.WarehouseMapper;
import uz.pdp.omnborxona.model.dto.WarehouseCreateDto;
import uz.pdp.omnborxona.model.dto.WarehouseDto;
import uz.pdp.omnborxona.model.dto.WarehouseUpdateDto;
import uz.pdp.omnborxona.model.entity.Warehouse;
import uz.pdp.omnborxona.repository.WarehouseRepository;
import uz.pdp.omnborxona.service.base.AbstractService;
import uz.pdp.omnborxona.service.base.CrudService;
import uz.pdp.omnborxona.validator.WarehouseValidator;

import java.util.List;

public class WarehouseService
        extends AbstractService<WarehouseMapper, WarehouseRepository, WarehouseValidator>
        implements CrudService<WarehouseDto, WarehouseCreateDto, WarehouseUpdateDto, String> {

    public WarehouseService(WarehouseMapper mapper, WarehouseRepository repository, WarehouseValidator validator) {
        super(mapper, repository, validator);
    }

    @Override
    public void create(WarehouseCreateDto dto) {
        Warehouse warehouse = mapper.fromDto(dto);
        repository.save(warehouse);
    }

    @Override
    public WarehouseDto update(WarehouseUpdateDto dto, String id) {
        Warehouse warehouse = validator.existsAndGet(id);
        mapper.fromDto(dto,warehouse);
        Warehouse save = repository.save(warehouse);
        return mapper.toDto(save);
    }

    @Override
    public WarehouseDto get(String id) {
        return mapper.toDto(validator.existsAndGet(id));
    }

    @Override
    public List<WarehouseDto> getAll() {
        List<Warehouse> warehouses = repository.findAll();
        return mapper.toDto(warehouses);
    }

    @Override
    public void delete(String id) {
        Warehouse warehouse = validator.existsAndGet(id);
        repository.delete(warehouse);
    }
}
