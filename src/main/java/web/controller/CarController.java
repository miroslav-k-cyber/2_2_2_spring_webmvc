package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {
    
    private final CarService carService;
    
    public CarController(CarService carService) {
        this.carService = carService;
    }
    
    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count,
                          Model model) {
        List<Car> cars = carService.getAllCars();
        
        if (count != null && count > 0 && count < 5) {
            cars = cars.subList(0, Math.min(count, cars.size()));
        }
        
        model.addAttribute("cars", cars);
        return "cars";
    }
    
    // для проверки, что контроллер работает
    @GetMapping("/")
    public String home() {
        return "redirect:/cars";
    }
}
