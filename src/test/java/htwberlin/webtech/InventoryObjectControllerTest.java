package htwberlin.webtech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InventoryController.class)
public class InventoryObjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryObjectService service;

    @Test
    @DisplayName("Test the Controller-Class")
    public void testGetRoute() throws Exception {
        InventoryObject inventoryObject = new InventoryObject("Bier", 2);
        inventoryObject.setId(420L);
        when(service.get(420L)).thenReturn(inventoryObject);

        String expected = "{\"id\":420,\"name\":\"Bier\",\"amount\":2}";

        this.mockMvc.perform(get("/inventoryObject/420"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}