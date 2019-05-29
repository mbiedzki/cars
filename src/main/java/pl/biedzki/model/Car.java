package pl.biedzki.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String producer;

    @NotBlank
    private String model;

    @Column(precision = 4, scale = 2)
    @NotNull
    private Double capacity;

    public Car (String producer, String model, Double capacity) {
        this.producer = producer;
        this.model = model;
        this.capacity = capacity;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return producer + ' ' + model + ' ' + capacity;
    }
}
