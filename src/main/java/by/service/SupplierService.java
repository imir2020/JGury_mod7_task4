package by.service;

import by.database.repository.SupplierRepository;
import by.dto.supplier_dto.FromSupplierDtoToBase;
import by.dto.supplier_dto.SupplierDto;
import by.mapper.classes.suppliers.DtoToSupplier;
import by.mapper.classes.suppliers.SupplierToDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository suppliersRepository;
    private final SupplierToDto supplierToDto;
    private final DtoToSupplier dtoToSupplier;

    public List<SupplierDto> findAll() {
        return suppliersRepository.findAll()
                .stream()
                .map(supplierToDto::mapFrom)
                .collect(Collectors.toList());
    }

    public Optional<SupplierDto> findById(Long id){
        return suppliersRepository.findById(id).map(supplierToDto::mapFrom);
    }

    public void save(FromSupplierDtoToBase fromSupplierDtoToBase){
        var supplier = dtoToSupplier.mapFrom(fromSupplierDtoToBase);
        suppliersRepository.save(supplier);
    }

    public void update(FromSupplierDtoToBase fromSupplierDtoToBase){

    }

    public void delete(Long id){
        suppliersRepository.deleteById(id);
    }
}
