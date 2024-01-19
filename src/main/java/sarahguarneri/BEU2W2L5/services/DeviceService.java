package sarahguarneri.BEU2W2L5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sarahguarneri.BEU2W2L5.DAO.DeviceDAO;
import sarahguarneri.BEU2W2L5.entites.Device;
import sarahguarneri.BEU2W2L5.entites.User;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceService {

    @Autowired
    private DeviceDAO deviceDAO;

    public List<Device> getDevices(){
        return deviceDAO.findAll();
    };

    public Device findById(UUID id){
        return deviceDAO.findById(id).orElseThrow(null);
    }

    public void findByIdAndDelete(UUID id){
        Device found = this.findById(id);
        deviceDAO.delete(found);
    }

    public Device save(Device body){
        Device newDevice = new Device();
        newDevice.setAvailable(body.getAvailable());
        newDevice.setType(body.getType());
        newDevice.setUser(body.getUser());
        return deviceDAO.save(newDevice);
    }

    public Device findByIdAndUpdate(UUID id, Device body){
        Device found =this.findById(id);
        found.setAvailable(body.getAvailable());
        found.setType(body.getType());
        found.setUser(body.getUser());
        return deviceDAO.save(found);
    }
}
