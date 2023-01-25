package weather.changer.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity(name = "sensors")
@Data
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "Не должно быть пустым")
    @Size(min = 6, max = 30,
            message = "Имя сенсора не должно превышать заданный размер от 6 до 30")
    private String name;
}
