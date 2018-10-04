package com.platform.auctionplatform.Models;

import javax.persistence.*;

@Entity
@Table(name="auction_item", schema="dbo")
public class AuctionItem {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    private int auctionItemId;

    @Column(columnDefinition = "varchar(2550)")
    private double currentBid;

    private double reservePrice;

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "itemId")
    private AuctionItem auctionItem;

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

    public AuctionItem getAuctionItem() {
        return auctionItem;
    }

    public void setAuctionItem(AuctionItem auctionItem) {
        this.auctionItem = auctionItem;
    }
}
