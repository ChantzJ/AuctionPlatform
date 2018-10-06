package com.platform.auctionplatform.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userTable", schema="dbo")
public class User {
    @Id
    @Column(name="userId",updatable = false, nullable = false, unique = true)
    private int userId;
    @Column(name="bidderName")
    private String name;
    @Column(name="maxAutoBidAmount")
    private int maxAutoBidAmount;

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
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