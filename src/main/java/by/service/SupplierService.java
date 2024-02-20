package by.service;

import by.database.repository.SuppliersRepository;
import by.dto.SuppliersDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SuppliersRepository suppliersRepository;

    public List<SuppliersDto> findAll() {
        return suppliersRepository.findAll().stream().map(suppliers ->
                        new SuppliersDto(suppliers.getId(),
                                ("%s| %s| %s| %s ").formatted(
                                        suppliers.getName(),
                                        suppliers.getAddress(),
                                        suppliers.getEmail(),
                                        suppliers.getPhoneNumber())))
                .collect(Collectors.toList());

    }
}
