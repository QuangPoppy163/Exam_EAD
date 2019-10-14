package t1708e.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t1708e.exam.entity.PublisherCatalog;

@Repository
public interface PublisherCatalogRepository extends JpaRepository<PublisherCatalog, Integer> {
}
