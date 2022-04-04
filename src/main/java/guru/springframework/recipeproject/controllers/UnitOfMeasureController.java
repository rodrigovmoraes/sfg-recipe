package guru.springframework.recipeproject.controllers;

import guru.springframework.recipeproject.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class UnitOfMeasureController {
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureController(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"/unitsOfMeasure.html"})
    public String unitsOfMeasurePage(Model model, @RequestParam("description")String description) {
        log.info("In unit of measure controller!");
        model.addAttribute("uoms", unitOfMeasureRepository.findByDescriptionLike(description));
        return "unitsOfMeasure";
    }
}
