package weather.changer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 7, max = 30, message = "Название области не должно превышать 30 символов")
    @Column(name = "oblast", unique = true)
    private String oblast;

    @Column(name = "name", unique = true)
    private String name;

}
