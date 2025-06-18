package pluralsight.GTA;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CitizenHtmlController {

    private final CitizenRepository repo;

    public CitizenHtmlController(CitizenRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/citizens")
    public String getAllCitizens(Model model) {
        List<Citizen> citizens = repo.findAll();
        System.out.println("Aantal voertuigen: " + citizens.size());

        model.addAttribute("citizens", citizens);
        return "citizens";
    }
    @GetMapping("/citizens/test")
    public String getTestCitizens(Model model) {
        List<Citizen> testCitizens = repo.findAll();
        if (testCitizens.isEmpty()) {
            System.out.println("⚠️ Geens voertuigen gevonden.");
            return "error"; // Zorg dat je een error.html hebt of een tekst teruggeeft
        }
        model.addAttribute("citizens", List.of(testCitizens.get(0)));
        return "citizens";
    }

    @GetMapping("/citizen/{id}")
    public String getCitizenById(@PathVariable Long id, Model model) {
        return repo.findById(id)
                .map(citizen -> {
                    model.addAttribute("citizen", citizen);
                    return "citizen";  // This is your Thymeleaf file: vehicle.html
                })
                .orElse("not-found");  // Optional: a custom 404 page
    }

}