package hello.coupang_clone.controller;

import hello.coupang_clone.domain.Item;
import hello.coupang_clone.request.AddItemRequest;
import hello.coupang_clone.request.EditItemRequest;
import hello.coupang_clone.response.ItemResponse;
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

    @GetMapping("/items")
    public String getItems(Model model) {
        List<ItemResponse> items = itemService.getItems();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("/items/{itemId}")
    public String getItem(@PathVariable Long itemId, Model model) {
        ItemResponse item = itemService.getItem(itemId);
        model.addAttribute("item", item);
        return "item";
    }

    @GetMapping("/items/add")
    public String addForm() {
        return "addForm";
    }

    @PostMapping("/items/add")
    public String addItem(@ModelAttribute AddItemRequest addItemRequest, RedirectAttributes redirectAttributes) {
        Item savedItem = itemService.addItem(addItemRequest);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/items/{itemId}";
    }

    @GetMapping("/items/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        ItemResponse item = itemService.getItem(itemId);
        model.addAttribute("item", item);
        return "editForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String editItem(@PathVariable Long itemId, @ModelAttribute EditItemRequest editItemRequest) {
        itemService.editItem(itemId, editItemRequest);
        return "redirect:/items/{itemId}";
    }

    @GetMapping("/items/{itemId}/delete")
    public String deleteItem(@PathVariable Long itemId) {
        itemService.deleteItem(itemId);
        return "redirect:/items";
    }
}
