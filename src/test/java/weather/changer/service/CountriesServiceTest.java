package weather.changer.service;

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
import weather.changer.model.Country;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CountriesServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CountriesService countriesService;

    @Test
    public void whenCountrySaveThenReturnJSON() throws Exception {
        Country country = new Country(2, "Germany");
        Mockito.when(countriesService.save(country)).thenReturn(Optional.of(country));
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/country/addCountry")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(country));
        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated());
        ArgumentCaptor<Country> argument = ArgumentCaptor.forClass(Country.class);
        verify(countriesService).save(argument.capture());
        Country value = argument.getValue();
        Assertions.assertEquals(value.getId(), 2);
        Assertions.assertEquals(value.getName(), "Germany");
    }
}