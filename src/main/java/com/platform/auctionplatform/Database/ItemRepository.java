package com.platform.auctionplatform.Database;

import com.platform.auctionplatform.Models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
