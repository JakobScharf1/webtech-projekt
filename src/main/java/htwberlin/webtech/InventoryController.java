package htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    InventoryObjectService service;

    @GetMapping("/")
    public String index(){
        return "Hello World!";
    }

    @PostMapping("/inventoryObject")
    public InventoryObject createInventoryObject(@RequestBody InventoryObject inventoryObject){
        return service.save(inventoryObject);
    }

    @GetMapping("/inventoryObject/{id}")
    public InventoryObject getInventoryObject(@PathVariable String id) {
        Long inventoryObjectId = Long.parseLong(id);
        return service.get(inventoryObjectId);
    }

    @GetMapping("/inventoryObject")
    public List<InventoryObject> getAllInventoryObjects(){
        return service.getAll();
    }

    @DeleteMapping("/inventoryObject/{id}")
    public void deleteInventoryObject(@PathVariable String id){
        Long inventoryObjectId = Long.parseLong(id);
        service.delete(inventoryObjectId);
    }
}