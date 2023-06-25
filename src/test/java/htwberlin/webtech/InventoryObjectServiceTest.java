package htwberlin.webtech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(InventoryController.class)
public class InventoryObjectServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryObjectService service;

    @Test
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
}
