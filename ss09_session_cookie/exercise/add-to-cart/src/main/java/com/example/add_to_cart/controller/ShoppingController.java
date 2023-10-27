package com.example.add_to_cart.controller;
import com.example.add_to_cart.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/cart")
public class ShoppingController {

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(value = "cart",required = false) CartDto cartDto) {
        return new ModelAndView("cart","cartDto",cartDto);
    }

    @GetMapping("/{id}/plus")
    public String plusProduct(@PathVariable Long id,@SessionAttribute(value = "cart",required = false) CartDto cartDto) {
        cartDto.plusCountProduct(id);
        return "redirect:/cart";
    }

    @GetMapping("/{id}/decrease")
    public String decreaseProduct(@PathVariable Long id,@SessionAttribute(value = "cart",required = false) CartDto cartDto) {
        cartDto.decreaseCountProduct(id);
        return "redirect:/cart";
    }

    @GetMapping("/{id}/delete")
    public String deleteToCard(@PathVariable Long id,@SessionAttribute(value = "cart",required = false) CartDto cartDto) {
        cartDto.deleteToCard(id);
        return "redirect:/cart";
    }
}
