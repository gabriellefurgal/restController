package legoSets;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Siekacz on 18.03.2017.
 */
public interface LegoSetTypeRepository extends JpaRepository<LegoSetType, Long> {
    LegoSetType findByName(String name);
    List<LegoSetTypeName> findAllProjectedBy();
}
