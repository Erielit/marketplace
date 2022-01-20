package mx.edu.utez.marketplace.subcategory.model;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    Optional<Subcategory> findByDescription(String description);
    List<Subcategory> findAllByCategoryId(long id);
    boolean existsById(long id);
}
