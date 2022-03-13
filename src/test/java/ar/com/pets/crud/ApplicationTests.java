package ar.com.pets.crud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;




import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
@ExtendWith( SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
	}
	
    @Test
    public void getsAllPets() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pets/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void getsSinglePet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pets/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
  /*  @Test
    public void returnsNotFoundForInvalidSinglePet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pets/44")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }*/
    @Test
    public void addsNewPet() throws Exception {
        String newPet = "{\"health\":55,\"id\":7,\"name\":\"Nemo\",\"type\":\"Fish\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/pets/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newPet)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void updPet() throws Exception {
        String updPet = "{\"health\":80,\"id\":87,\"name\":\"Nemo\",\"type\":\"Fish\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/pets/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updPet)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}


