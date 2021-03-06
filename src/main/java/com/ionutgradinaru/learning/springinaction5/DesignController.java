package com.ionutgradinaru.learning.springinaction5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignController {

  @GetMapping
  public String showDesignForm(Model model) {
    var ingredients = Arrays.asList(
        new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
        new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
        new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
        new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
        new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
        new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
        new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
        new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
        new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
        new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
    );

    var types = Ingredient.Type.values();
    for (var type : types) {
      model.addAttribute(type.toString().toLowerCase(),
          ingredients
              .stream()
              .filter(ingredient -> ingredient.getType().equals(type))
              .collect(Collectors.toList())
      );
    }

    model.addAttribute("design", new Taco());
    return "design";
  }

  @PostMapping
  public String processingDesign(@Valid Taco design, Errors errors) {
    if (errors.hasErrors()) {
      return "design";
    }

    log.info("Processing design: " + design);
    return "redirect:/orders/current";
  }
}
