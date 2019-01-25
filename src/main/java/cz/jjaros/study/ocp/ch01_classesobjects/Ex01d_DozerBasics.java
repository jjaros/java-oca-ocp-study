package cz.jjaros.study.ocp.ch01_classesobjects;

import cz.jjaros.study.helper.Console;
import cz.jjaros.study.ocp.ch01_classesobjects.support.mapping.ListDozerMapperCustom;
import cz.jjaros.study.ocp.ch01_classesobjects.support.mapping.dto.CarDto;
import cz.jjaros.study.ocp.ch01_classesobjects.support.mapping.entity.Car;
import cz.jjaros.study.ocp.ch01_classesobjects.support.mapping.entity.Manufacturer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basics of object mapping.
 * <br>
 * <br>
 * Most likely this will not be part of the exam.
 * Additionally, the Dozer is not the best mapping framework.
 * See great comparison of three main mapping frameworks
 * at <a href="https://www.baeldung.com/java-performance-mapping-frameworks">www.baeldung.com/java-performance-mapping-frameworks</a>.
 */
public class Ex01d_DozerBasics {

    public static void main(String[] args) {
        mapEntityToDto(new DozerBeanMapper());

        Console.lineDelimiter();
        lowLevelListMapping(new DozerBeanMapper());

        Console.lineDelimiter();
        customListMapping(new ListDozerMapperCustom());
    }

    // Map      Car{id=1, modelName='model_name', price=1250000, manufacturer=Manufacturer{name='manufacturer_name', city='manufacturer_city'}, note='car_note'}
    // to#1     CarDto{id=1, modelName='model_name', price=1250000, manufacturer=ManufacturerDto{name='manufacturer_name', city='manufacturer_city'}}
    // to#2     CarDto{id=1, modelName='model_name', price=1250000, manufacturer=ManufacturerDto{name='manufacturer_name', city='manufacturer_city'}}
    private static void mapEntityToDto(DozerBeanMapper mapper) {
        Car car = createCar();
        System.out.println("Map\t\t" + car);

        // prvni zpusob mapovani:
        CarDto mappedCar1 = mapper.map(car, CarDto.class);
        System.out.println("to#1\t" + mappedCar1);
        // druhy zpusob mapovani:
        CarDto mappedCar2 = new CarDto();
        mapper.map(car, mappedCar2);
        System.out.println("to#2\t" + mappedCar2);
    }

    // Map      [Car{id=1, modelName='model_name', price=1250000, manufacturer=Manufacturer{name='manufacturer_name', city='manufacturer_city'}, note='car_note'}]
    // to       [CarDto{id=1, modelName='model_name', price=1250000, manufacturer=ManufacturerDto{name='manufacturer_name', city='manufacturer_city'}}]
    private static void lowLevelListMapping(DozerBeanMapper mapper) {
        List<Car> cars = new ArrayList<>();
        cars.add(createCar());
        System.out.println("Map\t\t" + cars);

        List<CarDto> carDtos = cars.stream()
                .map(c -> mapper.map(c, CarDto.class))
                .collect(Collectors.toList());
        System.out.println("to\t\t" + carDtos);
    }

    // Map      [Car{id=1, modelName='model_name', price=1250000, manufacturer=Manufacturer{name='manufacturer_name', city='manufacturer_city'}, note='car_note'}]
    // to#I.    [CarDto{id=1, modelName='model_name', price=1250000, manufacturer=ManufacturerDto{name='manufacturer_name', city='manufacturer_city'}}]
    // to#II.   [CarDto{id=1, modelName='model_name', price=1250000, manufacturer=ManufacturerDto{name='manufacturer_name', city='manufacturer_city'}}]
    private static void customListMapping(ListDozerMapperCustom mapper) {
        List<Car> cars = new ArrayList<>();
        cars.add(createCar());
        System.out.println("Map\t\t" + cars);

        // varianta I.
        List<CarDto> carDtos1 = mapper.mapList(cars, CarDto.class);
        System.out.println("to#I.\t" + carDtos1);
        // varianta II.
        List<CarDto> carDtos2 = mapper.map(cars, CarDto.class);
        System.out.println("to#II.\t" + carDtos2);
    }

    private static Car createCar() {
        Car car = new Car();
        car.setId(1);
        car.setModelName("model_name");
        car.setPrice(1_250_000);
        car.setNote("car_note");

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCity("manufacturer_city");
        manufacturer.setName("manufacturer_name");
        car.setManufacturer(manufacturer);
        return car;
    }

    static {
        Logger.getRootLogger().setLevel(Level.OFF);
    }
}
