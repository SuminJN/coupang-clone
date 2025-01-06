package hello.coupang_clone.service;

import hello.coupang_clone.domain.Item;
import hello.coupang_clone.repository.ItemRepository;
import hello.coupang_clone.request.AddItemRequest;
import hello.coupang_clone.request.EditItemRequest;
import hello.coupang_clone.response.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<ItemResponse> getItems() {
        List<ItemResponse> list = new ArrayList<>();
        for (Item i : itemRepository.findAll()) {
            list.add(ItemResponse.builder()
                    .id(i.getId())
                    .name(i.getName())
                    .price(i.getPrice())
                    .stock(i.getStock())
                    .build());
        }
        return list;
    }

    public Item addItem(AddItemRequest addItemRequest) {
        Item item = Item.builder()
                .name(addItemRequest.getName())
                .price(addItemRequest.getPrice())
                .stock(addItemRequest.getStock())
                .build();

        return itemRepository.save(item);
    }

    public ItemResponse getItem(Long id) {
        Item findItem = itemRepository.findById(id).orElseThrow();
        return ItemResponse.builder()
                .id(findItem.getId())
                .name(findItem.getName())
                .price(findItem.getPrice())
                .stock(findItem.getStock())
                .build();
    }

    @Transactional
    public void editItem(Long id, EditItemRequest editItemRequest) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.edit(editItemRequest.getName(), editItemRequest.getPrice(), editItemRequest.getStock());
    }

    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow();
        itemRepository.delete(item);
    }
}
