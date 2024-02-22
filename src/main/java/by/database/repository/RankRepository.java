package by.database.repository;

import by.database.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RankRepository extends JpaRepository<Rank,Long > {

    List<Rank> findAllBy();

    Optional<Rank> findById(Long id);

    Rank save(Rank rank);

//    @Modifying
//    @Query("""
//            update Ranks  r
//            set r.rankName =: greid
//            where r.id =: id
//            """)
//    void updateRank(Greid greid,Long id);

    void deleteById(Long id);
}
