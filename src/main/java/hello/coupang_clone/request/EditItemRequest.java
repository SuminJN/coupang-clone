package hello.coupang_clone.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EditItemRequest {

    private String name;
    private int price;
    private int stock;
}
