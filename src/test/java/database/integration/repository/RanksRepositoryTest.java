package database.integration.repository;

import annotation.IT;
import by.database.entity.Ranks;
import by.database.repository.Greid;
import by.database.repository.RanksRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@IT
@RequiredArgsConstructor
public class RanksRepositoryTest {

    private final RanksRepository ranksRepository;

    @Test
    public void findAll() {
        List<Ranks> list = ranksRepository.findAllBy();
        assertTrue(list.size() > 0);
    }

    @Test
    public void findById() {
        Long rankId = 1L;
        Optional<Ranks> rank = ranksRepository.findById(rankId);
        assertTrue(rank.isPresent());
    }

    @Test
    public void save() {

        Ranks rank = Ranks.builder()
                .rankName(Greid.CLEANER)
                .salary(40000L)
                .build();
        ranksRepository.save(rank);

    }

    @Test
    public void update() {
        Long id = 1L;

        Ranks rank = ranksRepository.findById(id).get();
        rank.setSalary(45000L);
        ranksRepository.save(rank);
    }

    @Test
    public void delete() {
        Long rankId = 1L;
        ranksRepository.deleteById(rankId);
        Optional<Ranks> rank = ranksRepository.findById(rankId);
        assertTrue(rank.isEmpty());
    }
}
