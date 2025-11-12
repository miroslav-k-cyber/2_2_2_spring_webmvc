package web.dao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    
    private  final List<Car> cars = new ArrayList<>();
    
    public CarDaoImpl(){
        cars.add (new Car("ВАЗ", "2107", 1998));
        cars.add (new Car("ГАЗ", "Волга", 2003));
        cars.add (new Car("УАЗ", "Патриот", 2015));
        cars.add (new Car("ЗАЗ", "Таврия", 1995));
        cars.add (new Car("ЛИАЗ", "677", 1986));
    }
    
    @Override
    public List<Car> getAllCars() {
        return cars;
    }
    
    @Override
    public List<Car> getCountCars(int count) {
        return cars.subList(0, Math.min(count, cars.size()));
    }
}
