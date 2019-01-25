package cz.jjaros.study.ocp.ch01_classesobjects.support.mapping.dto;

public class ManufacturerDto {

    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ManufacturerDto{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
