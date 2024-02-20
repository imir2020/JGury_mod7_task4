package by.database.repository;

import by.database.entity.Ranks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RanksRepository extends JpaRepository<Ranks,Long > {

    List<Ranks> findAllBy();

    Optional<Ranks> findById(Long id);

    Ranks save(Ranks rank);

//    @Modifying
//    @Query("""
//            update Ranks  r
//            set r.rankName =: greid
//            where r.id =: id
//            """)
//    void updateRank(Greid greid,Long id);

    void deleteById(Long id);
}
