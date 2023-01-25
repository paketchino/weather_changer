package weather.changer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weather.changer.dto.CountryDTO;
import weather.changer.model.Country;
import weather.changer.service.CountriesService;

import javax.validation.Valid;

@RestController
@RequestMapping("/country")
@AllArgsConstructor
public class CountryController {

    private final CountriesService countriesService;

    @PostMapping("/addCountry")
    public ResponseEntity<CountryDTO> addCity(@Valid @RequestBody Country country) {
        countriesService.save(country);
        return new ResponseEntity<>(new CountryDTO(country.getName()), HttpStatus.CREATED);
    }
}
