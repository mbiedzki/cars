package pl.biedzki.model;


public class Car {

    private Long id;
    private String producer;
    private String model;
    private Double capacity;


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
