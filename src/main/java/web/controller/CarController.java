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
        List<Car> cars;
        
        if (count == null) {
            // count не передан → возвращаем весь список
            cars = carService.getAllCars();
        } else if (count >= 5) {
            // count >= 5 → контроллер решает вернуть весь список
            cars = carService.getAllCars();
        } else {
            // count < 5 → возвращаем count машин
            cars = carService.getCountCars(count);
        }
        
        model.addAttribute("cars", cars);
        return "cars"; // Thymeleaf-шаблон
    }
    
    @GetMapping("/")
    public String home() {
        return "redirect:/cars";
    }
}
