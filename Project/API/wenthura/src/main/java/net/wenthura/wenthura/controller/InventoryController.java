package net.wenthura.wenthura.controller;


import net.wenthura.wenthura.exception.ResourceNotFoundException;
import net.wenthura.wenthura.model.Inventory;
import net.wenthura.wenthura.repository.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/inv")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/inventory/all")
    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }

    @GetMapping("/inventory/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable(value = "id") Long inventoryId)
        throws ResourceNotFoundException {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for this id :: " + inventoryId));
        return ResponseEntity.ok().body(inventory);
    }

    @PostMapping("/inventory")
    public Inventory createInventory(@Valid @RequestBody Inventory inventory) {

        return inventoryRepository.save(inventory);
    }

    @PutMapping("/inventory/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable(value = "id") Long inventoryId,
                                                   @Valid @RequestBody Inventory inventoryDetails) throws ResourceNotFoundException {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for this id :: " + inventoryId));

        inventory.setInvenName(inventoryDetails.getInvenName());
        inventory.setInvenPrice(inventoryDetails.getInvenPrice());
        inventory.setInvenCategory(inventoryDetails.getInvenCategory());
        inventory.setInvenAvailability(inventoryDetails.getInvenAvailability());
        inventory.setInvenQuantity(inventoryDetails.getInvenQuantity());
        final Inventory updatedInventory = inventoryRepository.save(inventory);
        return ResponseEntity.ok(updatedInventory);
    }

    @DeleteMapping("/inventory/{id}")
    public Map<String, Boolean> deleteInventory(@PathVariable(value = "id") Long inventoryId)
            throws ResourceNotFoundException {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for this id :: " + inventoryId));

        inventoryRepository.delete(inventory);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
