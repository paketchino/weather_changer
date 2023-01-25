package weather.changer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreetDTO {

    private String country;

    private String oblast;

    private String cities;

    private String street;

    private int index;
}
