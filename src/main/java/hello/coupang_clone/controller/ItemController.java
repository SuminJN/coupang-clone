package hello.coupang_clone.controller;

import hello.coupang_clone.domain.Item;
import hello.coupang_clone.request.AddItemForm;
import hello.coupang_clone.request.EditItemForm;
import hello.coupang_clone.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/items")
    public String items(Model model) {
        List<Item> items = itemService.getItems();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("/items/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemService.getItem(itemId);
        model.addAttribute("item", item);
        return "item";
    }

    @GetMapping("/items/add")
    public String addForm() {
        return "addForm";
    }

    @PostMapping("/items/add")
    public String addItem(@ModelAttribute AddItemForm addItemForm, RedirectAttributes redirectAttributes) {
        Item savedItem = itemService.addItem(addItemForm);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/items/{itemId}";
    }

    @GetMapping("/items/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemService.getItem(itemId);
        model.addAttribute("item", item);
        return "editForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute EditItemForm editItemForm) {
        itemService.editItem(itemId, editItemForm);
        return "redirect:/items/{itemId}";
    }
}
