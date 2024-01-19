package sarahguarneri.BEU2W2L5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sarahguarneri.BEU2W2L5.entites.Device;
import sarahguarneri.BEU2W2L5.services.DeviceService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<Device> getDevices(){
        return deviceService.getDevices();
    }

    @PostMapping
    public Device postDevice(@PathVariable Device newDevice){
        return deviceService.save(newDevice);
    }

    @PutMapping("/deviceId")
    public Device putDevice(@PathVariable UUID id, @RequestBody Device body){
        return deviceService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/deviceId")
    public void deleteDevice(@PathVariable UUID id){
        deviceService.findByIdAndDelete(id);
    }

    @GetMapping("/deviceId")
    public Device getDeviceById(@PathVariable UUID id){
        return deviceService.findById(id);
    }
}
