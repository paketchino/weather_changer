package weather.changer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MeasurementDTO {

    private double value;

    private boolean raining;

    private String city;

    private String street;

    private String sensorName;

    private LocalDateTime start;

    private LocalDateTime finish;
}
