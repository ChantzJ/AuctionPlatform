package com.platform.auctionplatform.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="userId",updatable = false, nullable = false, unique = true)
    private int id;
    @Column(name="bidderName")
    private String name;
    @Column(name="maxAutoBidAmount")
    private int maxAutoBidAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxAutoBidAmount() {
        return maxAutoBidAmount;
    }

    public void setMaxAutoBidAmount(int maxAutoBidAmount) {
        this.maxAutoBidAmount = maxAutoBidAmount;
    }
}