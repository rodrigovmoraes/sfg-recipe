package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UnitOfMeasureController {
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureController(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"/unitsOfMeasure.html"})
    public String unitsOfMeasurePage(Model model, @RequestParam("description")String description) {
        model.addAttribute("uoms", unitOfMeasureRepository.findByDescriptionLike(description));
        return "unitsOfMeasure";
    }
}
