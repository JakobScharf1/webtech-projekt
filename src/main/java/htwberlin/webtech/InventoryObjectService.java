package htwberlin.webtech;

import org.springframework.beans.factory.annotation.Autowired;

public class InventoryObjectService {

    @Autowired
    InventoryObjectRepository repo;

    public InventoryObject save(InventoryObject inventoryObject) {
        return repo.save(inventoryObject);
    }

    public InventoryObject get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

}
