package pl.pawel.devicerent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.devicerent.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
