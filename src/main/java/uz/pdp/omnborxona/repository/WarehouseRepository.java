package uz.pdp.omnborxona.repository;

import uz.pdp.omnborxona.model.entity.Warehouse;
import uz.pdp.omnborxona.repository.base.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepository extends CrudRepository<Warehouse, String> {

    Optional<Warehouse> findById(String id);

    List<Warehouse> findAll();

    /**
     * @param entity bu saqlanoyatgan object malumotlari
     * @return saqlangandan keyingi holarti
     */
    Warehouse save(Warehouse entity);

    void delete(Warehouse entity);
}
