package weather.changer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import weather.changer.model.City;

import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CitiesServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CitiesService citiesService;

    @Test
    public void whenCitiesAddThenReturnJSON() throws Exception {
        City city = new City(20, "Saratovskay Obl.", "Saratov");
        Mockito.when(citiesService.save(city)).thenReturn(Optional.of(city));
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/cities/addCity")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(city));
        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated());
        ArgumentCaptor<City> argument = ArgumentCaptor.forClass(City.class);
        verify(citiesService).save(argument.capture());
        City value = argument.getValue();
        Assertions.assertEquals(value.getId(), 20);
        Assertions.assertEquals(value.getName(), "Saratov");
    }
}