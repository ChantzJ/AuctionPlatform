package com.platform.auctionplatform.Database;

import com.platform.auctionplatform.Models.Bid;
import org.springframework.data.repository.CrudRepository;

public interface BidRespository extends CrudRepository<Bid, Integer> {
}
