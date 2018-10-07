package com.platform.auctionplatform.Models;

import javax.persistence.*;

@Entity
@Table(name="bid", schema="dbo")
public class Bid {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int auctionItemId;

    private double maxAutoBidAmount;

    private String bidderName;

    private double bidAmount;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuctionItemId() {
        return auctionItemId;
    }

    public void setAuctionItemId(int auctionItemId) {
        this.auctionItemId = auctionItemId;
    }

    public double getMaxAutoBidAmount() {
        return maxAutoBidAmount;
    }

    public void setMaxAutoBidAmount(double maxAutoBidAmount) {
        this.maxAutoBidAmount = maxAutoBidAmount;
    }

    public String getBidderName() {
        return bidderName;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }
}