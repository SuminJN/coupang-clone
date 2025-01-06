package hello.coupang_clone.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemResponse {

    private final Long id;
    private final String name;
    private final int price;
    private final int stock;

}
