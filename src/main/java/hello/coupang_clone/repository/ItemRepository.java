package hello.coupang_clone.repository;

import hello.coupang_clone.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}