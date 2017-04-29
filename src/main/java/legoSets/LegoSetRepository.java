package legoSets;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Siekacz on 18.03.2017.
 */
public interface LegoSetRepository extends JpaRepository<LegoSet, Long> {
    Collection<LegoSet> findByLegoSetTypeName(String setName);
    List<LegoSetData> findAllProjectedBy();
}
