package hello.coupang_clone.request;

import hello.coupang_clone.domain.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class EditItemForm {

    private Long id;
    private String name;
    private int price;
    private int stock;

    public static EditItemForm form(Item item) {
        return EditItemForm.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .stock(item.getStock())
                .build();
    }
}
