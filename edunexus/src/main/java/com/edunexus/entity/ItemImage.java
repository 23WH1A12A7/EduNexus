package com.edunexus.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item_image")
public class ItemImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    // Constructors
    public ItemImage() {}

    public ItemImage(String imageUrl, Item item) {
        this.imageUrl = imageUrl;
        this.item = item;
    }

    // Getters and Setters
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
