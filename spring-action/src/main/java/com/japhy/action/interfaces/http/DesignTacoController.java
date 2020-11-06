package com.japhy.action.interfaces.http;

import com.google.common.collect.Lists;
import com.japhy.action.domain.taco.enums.Type;
import com.japhy.action.domain.taco.model.dao.TacoDao;
import com.japhy.action.domain.taco.model.dao.TacoJpaRepository;
import com.japhy.action.domain.taco.model.entity.Ingredient;
import com.japhy.action.domain.taco.model.entity.Taco;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Japhy
 * @since 2020/7/6 14:53
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/design")
public class DesignTacoController {

    private final TacoDao tacoJdbcDao;
    private final TacoJpaRepository tacoJpaRepository;

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredientList =
            Lists.newArrayList(
                new Ingredient("FLOT", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GTBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CHED", "Cheddar", Type.CHEESE));
        Type[] types = Type.values();
        for (Type type : types) {
            List<Ingredient> collect =
                ingredientList.stream().filter(ingredient -> ingredient.getType().equals(type))
                    .collect(
                        Collectors.toList());
            model.addAttribute(type.toString().toLowerCase(), collect);
        }
        model.addAttribute("taco", new Taco());
        return "design";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Taco showDesignForm(@Valid Taco taco) {
        Iterable<Taco> all = tacoJdbcDao.findAll();
        all.forEach(t -> log.info(t.toString()));
        tacoJpaRepository.save(taco);
        Taco taco3 = tacoJpaRepository.findBydemo("taco3");
        log.info(taco3.toString());
        return taco;
    }
}
