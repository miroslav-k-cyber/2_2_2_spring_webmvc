package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    
    private final List<Car> cars = List.of(
            new Car("ВАЗ", "2107", 1998),
            new Car("ГАЗ", "Волга", 2003),
            new Car("УАЗ", "Патриот", 2015),
            new Car("ЗАЗ", "Таврия", 1995),
            new Car("ЛИАЗ", "677", 1986)
    );
    
    @Override
    public List<Car> getAllCars() {
        return cars;
    }

}
