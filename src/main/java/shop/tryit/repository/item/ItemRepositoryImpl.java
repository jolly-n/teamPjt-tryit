package shop.tryit.repository.item;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import shop.tryit.domain.item.Item;
import shop.tryit.domain.item.ItemRepository;
import shop.tryit.domain.item.ItemSearchCondition;
import shop.tryit.domain.item.ItemSearchDto;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;

    @Override
    public Long save(Item item) {
        log.info("save: item = {}", item);
        return itemJpaRepository.save(item).getId();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemJpaRepository.findById(id);
    }

    @Override
    public List<Item> findAll() {
        return itemJpaRepository.findAll();
    }

    @Override
    public void delete(Item item) {
        itemJpaRepository.delete(item);
    }

    @Override
    public Page<ItemSearchDto> searchItems(ItemSearchCondition condition, Pageable pageable) {
        return itemJpaRepository.searchItems(condition, pageable);
    }

    @Override
    public ItemSearchDto findItemSearchDtoByOrderDetailId(Long orderDetailItemId) {
        return itemJpaRepository.findItemSearchDtoByOrderDetailId(orderDetailItemId);
    }

}
