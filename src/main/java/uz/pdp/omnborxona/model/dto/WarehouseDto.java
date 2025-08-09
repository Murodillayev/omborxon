package uz.pdp.omnborxona.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class WarehouseDto {
    private String id;
    private String name;
}
