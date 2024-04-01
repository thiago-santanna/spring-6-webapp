package tss.webapp.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tss.webapp.spring6webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
