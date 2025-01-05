package hello.coupang_clone.service;

import hello.coupang_clone.domain.Item;
import hello.coupang_clone.repository.ItemRepository;
import hello.coupang_clone.request.AddItemForm;
import hello.coupang_clone.request.EditItemForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public void addItem(AddItemForm addItemForm) {
        Item item = Item.builder()
                .name(addItemForm.getName())
                .price(addItemForm.getPrice())
                .stock(addItemForm.getStock())
                .build();

        itemRepository.save(item);
    }

    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void editItem(EditItemForm form) {
        Item item = itemRepository.findById(form.getId()).orElseThrow();
        item.edit(form.getName(), form.getPrice(), form.getStock());
    }

    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        itemRepository.delete(item);
    }
}
