package com.platform.auctionplatform.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbContext {

    @Autowired
    private BidRespository bidRespository;
    @Autowired
    private AuctionItemRepository auctionItemRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;

    public DbContext(){}

    public BidRespository bids() {
        return bidRespository;
    }

    public AuctionItemRepository auctionItems() {
        return auctionItemRepository;
    }

    public ItemRepository items() {
        return itemRepository;
    }

    public UserRepository users() {
        return userRepository;
    }


    /**
     * Converts a repository iterable to a list for easier manipulation
     *
     * @param collection to convert
     * @param <T> class type the list contains
     * @return list of type <T>
     */
    public <T> List<T> toList(Iterable<T> collection) {
        List<T> list = new ArrayList<>();

        collection.forEach(list::add);

        return list;
    }
}