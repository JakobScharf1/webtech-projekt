package htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    InventoryObjectService service;

    @GetMapping("/inventoryObject")
    public List<InventoryObject> getAllInventoryObjects(){
        return service.getAll();
    }

    @GetMapping("/inventoryObject/{id}")
    public InventoryObject getInventoryObject(@PathVariable String id) {
        Long inventoryObjectId = Long.parseLong(id);
        return service.get(inventoryObjectId);
    }

    @PostMapping("/inventoryObject")
    public InventoryObject createInventoryObject(@RequestBody InventoryObject inventoryObject){
        return service.save(inventoryObject);
    }

    @PutMapping("/inventoryObject/{id}/{name}/{amount}")
    public void updateInventoryObject(@PathVariable("id") String id, @PathVariable("name") String name, @PathVariable("amount") int amount) {
        Long inventoryObjectId = Long.parseLong(id);
        service.update(inventoryObjectId, name, amount);
    }

    @DeleteMapping("/inventoryObject/{id}")
    public void deleteInventoryObject(@PathVariable String id){
        Long inventoryObjectId = Long.parseLong(id);
        service.delete(inventoryObjectId);
    }
}