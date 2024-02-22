package by.mapper.classes.suppliers;


import by.database.entity.Supplier;
import by.dto.supplier_dto.SupplierDto;
import by.mapper.map_interfaces.supplier.SupplierToDtoMapper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class SupplierToDto {
    public SupplierDto mapFrom(Supplier supplier){
        return SupplierToDtoMapper.INSTANCE.mapFrom(supplier);
    }

}
