package net.wenthura.wenthura.controller;


import net.wenthura.wenthura.exception.ResourceNotFoundException;
import net.wenthura.wenthura.model.Vehicle;
import net.wenthura.wenthura.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/veh")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/vehicle/all")
    public List<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Long vehicleId)
        throws ResourceNotFoundException {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vehicleId));
        return ResponseEntity.ok().body(vehicle);
    }

    @PostMapping("/vehicle")
    public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {

        return vehicleRepository.save(vehicle);
    }

    @PutMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable(value = "id") Long vehicleId,
                                                   @Valid @RequestBody Vehicle vehicleDetails) throws ResourceNotFoundException {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vehicleId));

        vehicle.setVehNumber(vehicleDetails.getVehNumber());
        vehicle.setVehType(vehicleDetails.getVehType());
        vehicle.setVehModel(vehicleDetails.getVehModel());
        vehicle.setVehPrice(vehicleDetails.getVehPrice());
        vehicle.setvehAvailability(vehicleDetails.getvehAvailability());
        final Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/vehicle/{id}")
    public Map<String, Boolean> deleteVehicle(@PathVariable(value = "id") Long vehicleId)
            throws ResourceNotFoundException {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vehicleId));

        vehicleRepository.delete(vehicle);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
