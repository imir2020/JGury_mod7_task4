package database.integration.repository;

import annotation.IT;
import by.database.entity.Rank;
import by.database.repository.Greid;
import by.database.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IT
@RequiredArgsConstructor
public class RankRepositoryTest {

    private final RankRepository ranksRepository;

    @Test
    public void findAll() {
        List<Rank> list = ranksRepository.findAllBy();
        assertTrue(list.size() > 0);
    }

    @Test
    public void findById() {
        Long rankId = 1L;
        Optional<Rank> rank = ranksRepository.findById(rankId);
        assertTrue(rank.isPresent());
    }

    @Test
    public void save() {

        Rank rank = Rank.builder()
                .rankName(Greid.CLEANER)
                .salary(40000L)
                .build();
        ranksRepository.save(rank);

    }

    @Test
    public void update() {
        Long id = 1L;

        Rank rank = ranksRepository.findById(id).get();
        rank.setSalary(45000L);
        ranksRepository.save(rank);
    }

    @Test
    public void delete() {
        Long rankId = 1L;
        ranksRepository.deleteById(rankId);
        Optional<Rank> rank = ranksRepository.findById(rankId);
        assertTrue(rank.isEmpty());
    }
}
