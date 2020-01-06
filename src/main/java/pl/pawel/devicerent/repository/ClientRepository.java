package pl.pawel.devicerent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.devicerent.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
