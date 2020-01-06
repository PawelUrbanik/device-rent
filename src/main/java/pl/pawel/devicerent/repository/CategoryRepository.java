package pl.pawel.devicerent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.devicerent.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
