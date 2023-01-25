package weather.changer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "countries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Не должно быть пустым")
    @Size(min = 6, max = 16, message = "Должен соответствовать параметрам от 6 до 16")
    @Column(name = "name", unique = true)
    private String name;
}
