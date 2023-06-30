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

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(InventoryController.class)
public class InventoryObjectServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private InventoryObjectRepository repository;

    @InjectMocks
    private InventoryObjectService serviceInject;

    @MockBean
    private InventoryObjectService service;

    @Test
    @DisplayName("Test the HTTP-Get method for an inventory object")
    public void testGetRoute() throws Exception {
        InventoryObject i1 = new InventoryObject("Kasten Bier Pils", 2);
        i1.setId(42L);
        when(service.get(42L)).thenReturn(i1);

        String expected = "{\"id\":42,\"name\":\"Kasten Bier Pils\",\"amount\":2}";

        this.mockMvc.perform(get("inventoryObjects/42"))
            .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    @DisplayName("Test the HTTP-Post method for an inventory object")
    public void testPostInventoryObject() throws Exception {
        // Test wirft derzeit noch NullPointerException
        InventoryObject inventoryObject = new InventoryObject("Bier", 2);

        var expected = inventoryObject;
        var actual = service.save(inventoryObject);

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAmount(), actual.getAmount());
    }

    @Test
    @DisplayName("Test the HTTP-Put method for an inventory object")
    public void testPutInventoryObject() throws Exception {
        // Test wirft derzeit noch NullPointerException
        InventoryObject inventoryObject = new InventoryObject("Bier", 2);

        repository.save(inventoryObject);

        Long inventoryObjectId = inventoryObject.getId();

        doReturn(true).when(repository).existsById(inventoryObjectId);

        System.out.println(inventoryObject);

        var actual = serviceInject.update(inventoryObjectId, "Pils", 5);

        assertEquals("Pils", actual.getName());
        assertEquals(5, actual.getAmount());
    }

    @Test
    @DisplayName("Test the HTTP-Delete method for an inventory object")
    public void testDeleteInventoryObject() throws Exception {
        InventoryObject inventoryObject = new InventoryObject("Bier", 2);

        repository.save(inventoryObject);

        Long inventoryObjectId = inventoryObject.getId();

        doReturn(true).when(repository).existsById(inventoryObjectId);

        var expected = true;
        var actual = serviceInject.delete(inventoryObjectId);

        assertEquals(expected, actual);
    }
}