package com.platform.auctionplatform.Database;

import com.platform.auctionplatform.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
