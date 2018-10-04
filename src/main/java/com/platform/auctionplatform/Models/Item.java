package com.platform.auctionplatform.Models;

import javax.persistence.*;

@Entity
@Table(name="item", schema="dbo")
public class Item {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    @GeneratedValue
    private int itemId;

    @Column(columnDefinition = "varchar(2550)")
    private String description;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}