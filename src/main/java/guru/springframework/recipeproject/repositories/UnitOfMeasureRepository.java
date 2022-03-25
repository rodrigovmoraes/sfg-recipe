package guru.springframework.recipeproject.repositories;

import guru.springframework.recipeproject.domain.UnitOfMeasure;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    public Optional<UnitOfMeasure> findByDescription(String description);
    @Query("SELECT uom FROM UnitOfMeasure uom WHERE uom.description LIKE :description%")
    public List<UnitOfMeasure> findByDescriptionLike(@Param("description")String description);
}
