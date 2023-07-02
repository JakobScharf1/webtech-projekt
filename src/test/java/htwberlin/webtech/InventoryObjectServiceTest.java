package htwberlin.webtech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class InventoryObjectServiceTest {

    @Mock
    private InventoryObjectRepository repository;

    @InjectMocks
    private InventoryObjectService serviceInject;

    @Test
    @DisplayName("Test the HTTP-Get method for an inventory object")
    public void testGetRoute() {
        var inventoryObject = new InventoryObject("Bier", 2);

        inventoryObject.setId(420L);

        Long inventoryObjectId = inventoryObject.getId();

        doReturn(Optional.of(inventoryObject)).when(repository).findById(inventoryObjectId);

        var expected = new InventoryObject("Bier", 2);
        var actual = serviceInject.get(inventoryObjectId);

        assertEquals(420, actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAmount(), actual.getAmount());
    }

    @Test
    @DisplayName("Test the HTTP-Post method for an inventory object")
    public void testPostInventoryObject() {
        var inventoryObject = new InventoryObject("Bier", 2);

        inventoryObject.setId(420L);

        doReturn(Optional.of(inventoryObject).get()).when(repository).save(inventoryObject);

        var expected = new InventoryObject("Bier", 2);
        var actual = serviceInject.save(inventoryObject);

        assertEquals(420, actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAmount(), actual.getAmount());
    }

    @Test
    @DisplayName("Test the HTTP-Put method for an inventory object")
    public void testPutInventoryObject() {
        var inventoryObject = new InventoryObject("Bier", 2);

        inventoryObject.setId(420L);

        Long inventoryObjectId = inventoryObject.getId();

        doReturn(Optional.of(inventoryObject)).when(repository).findById(inventoryObjectId);

        var expected = new InventoryObject("Pils", 5);
        var actual = serviceInject.update(inventoryObjectId, "Pils", 5);

        assertEquals(420, actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAmount(), actual.getAmount());
    }

    @Test
    @DisplayName("Test the HTTP-Delete method for an inventory object")
    public void testDeleteInventoryObject() {
        var inventoryObject = new InventoryObject("Bier", 2);

        inventoryObject.setId(420L);

        Long inventoryObjectId = inventoryObject.getId();

        doReturn(true).when(repository).existsById(inventoryObjectId);

        var expected = true;
        var actual = serviceInject.delete(inventoryObjectId);

        assertEquals(expected, actual);
    }
}