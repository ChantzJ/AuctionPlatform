package com.platform.auctionplatform.Models;

import javax.persistence.*;

@Entity
@Table(name="item", schema="dbo")
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private int itemId;

    public Item() { }

    public Item(int itemId) {
        this.itemId = itemId;
    }

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