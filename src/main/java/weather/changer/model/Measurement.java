package weather.changer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "measurements")
@Getter
@Setter
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Не должно быть пустым")
    private boolean raining;

    @DecimalMin(value = "-100.0", message = "Температура не должна превышать -100.0", inclusive = true)
    @DecimalMax(value = "100.0", message = "Температура не должна превышать 100.0", inclusive = true)
    @NotNull(message = "Не должно быть пустым")
    private Double value;

    @NotNull(message = "Не должно быть пустым")
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "street_id")
    private Street street;

    @NotNull(message = "Не должно быть пустым")
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @NotNull(message = "Не должно быть пустым")
    @Column(name = "start")
    private LocalDateTime start = LocalDateTime.now();

    @NotNull(message = "Не должно быть пустым")
    @Column(name = "finish")
    private LocalDateTime finish = LocalDateTime.now().plusHours(1);

    @Override
    public String toString() {
        return "Measurement{" +
                "raining=" + raining +
                ", value=" + value +
                ", sensor=" + sensor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Measurement that = (Measurement) o;
        return id == that.id && raining == that.raining
                && Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, raining, value);
    }
}
