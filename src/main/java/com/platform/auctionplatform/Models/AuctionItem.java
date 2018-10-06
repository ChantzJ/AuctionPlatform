package com.platform.auctionplatform.Models;

import javax.persistence.*;

@Entity
@Table(name="auction_item", schema="dbo")
public class AuctionItem {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    @GeneratedValue
    private int auctionItemId;

    @Column(columnDefinition = "varchar(2550)")
    private double currentBid;

    private double reservePrice;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id")
    private Item item;

    public int getAuctionItemId() {
        return auctionItemId;
    }

    public void setAuctionItemId(int auctionItemId) {
        this.auctionItemId = auctionItemId;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(double reservePrice) {
        this.reservePrice = reservePrice;
    }

    public Item getAuctionItem() {
        return item;
    }

    public void setAuctionItem(Item item) {
        this.item = item;
    }
}
