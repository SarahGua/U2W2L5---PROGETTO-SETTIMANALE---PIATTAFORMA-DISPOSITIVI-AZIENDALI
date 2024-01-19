package sarahguarneri.BEU2W2L5.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sarahguarneri.BEU2W2L5.entites.Device;

import java.util.UUID;

@Repository
public interface DeviceDAO extends JpaRepository<Device, UUID> {
}
