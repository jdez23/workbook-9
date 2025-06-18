package pluralsight.GTA;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHtmlController {

    private final VehicleRepository repo;

    public VehicleHtmlController(VehicleRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/vehicles")
    public String getAllVehicles(Model model) {
        List<Vehicle> vehicles = repo.findAll();
        System.out.println("Aantal voertuigen: " + vehicles.size());

        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }
    @GetMapping("/vehicles/test")
    public String getTestVehicles(Model model) {
        List<Vehicle> testVehicles = repo.findAll();
        if (testVehicles.isEmpty()) {
            System.out.println("⚠️ Geens voertuigen gevonden.");
            return "error"; // Zorg dat je een error.html hebt of een tekst teruggeeft
        }
        model.addAttribute("vehicles", List.of(testVehicles.get(0)));
        return "vehicles";
    }

    @GetMapping("/vehicle/{id}")
    public String getVehicleById(@PathVariable Long id, Model model) {
        return repo.findById(id)
                .map(vehicle -> {
                    model.addAttribute("vehicle", vehicle);
                    return "vehicle";  // This is your Thymeleaf file: vehicle.html
                })
                .orElse("not-found");  // Optional: a custom 404 page
    }

}