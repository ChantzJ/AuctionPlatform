package com.platform.auctionplatform.Models;

import javax.persistence.*;

@Entity
@Table(name="userTable", schema="dbo")
public class User {
    @Id
    @Column(name="userId",updatable = false, nullable = false, unique = true)
    @GeneratedValue
    private int userId;
    @Column(name="bidderName")
    private String bidderName;
    @Column(name="maxAutoBidAmount")
    private int maxAutoBidAmount;

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getName() {
        return bidderName;
    }

    public void setName(String name) {
        this.bidderName = name;
    }

    public int getMaxAutoBidAmount() {
        return maxAutoBidAmount;
    }

    public void setMaxAutoBidAmount(int maxAutoBidAmount) {
        this.maxAutoBidAmount = maxAutoBidAmount;
    }
}