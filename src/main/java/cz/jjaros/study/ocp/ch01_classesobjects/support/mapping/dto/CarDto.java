package cz.jjaros.study.ocp.ch01_classesobjects.support.mapping.dto;

public class CarDto {

    private int id;
    private String modelName;
    private int price;
    private ManufacturerDto manufacturer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ManufacturerDto getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerDto manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
