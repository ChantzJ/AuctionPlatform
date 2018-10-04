package com.platform.auctionplatform.Database;

import com.platform.auctionplatform.Models.AuctionItem;
import org.springframework.data.repository.CrudRepository;

public interface AuctionItemRepository extends CrudRepository<AuctionItem, Integer> {
}
