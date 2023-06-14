package htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InventoryObjectService {

    @Autowired
    InventoryObjectRepository repo;

    public List<InventoryObject> getAll() {
        Iterable<InventoryObject> iterator = repo.findAll();
        List<InventoryObject> inventoryObjects = new ArrayList<>();
        for (InventoryObject inventoryObject : iterator) inventoryObjects.add(inventoryObject);
        return inventoryObjects;
    }

    public InventoryObject get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public InventoryObject save(InventoryObject inventoryObject) {
        return repo.save(inventoryObject);
    }

    public void update(Long id, int amount) {
        //repo.findById(id).setAmount(amount);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
