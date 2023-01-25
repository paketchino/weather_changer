package weather.changer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weather.changer.dto.StreetDTO;
import weather.changer.model.City;
import weather.changer.model.Country;
import weather.changer.model.Street;
import weather.changer.service.CitiesService;
import weather.changer.service.CountriesService;
import weather.changer.service.StreetService;
import javax.validation.Valid;

@RestController
@RequestMapping("/streets")
@AllArgsConstructor
public class StreetController {

    private final StreetService streetService;
    private CitiesService citiesService;
    private CountriesService countriesService;

    @PostMapping("/addStreet")
    public ResponseEntity<StreetDTO> addStreet(@Valid @RequestBody Street street) {
        City byName = citiesService.findByName(street.getCity().getName()).orElseThrow();
        street.setCity(byName);
        Country country = countriesService.findByName(street.getCountry().getName()).orElseThrow();
        street.setCountry(country);
        streetService.save(street);
        return new ResponseEntity<>(new StreetDTO(
                street.getCountry().getName(),
                street.getCity().getOblast(),
                street.getCity().getName(),
                street.getName(),
                street.getIndex()),
                HttpStatus.CREATED);
    }
}
