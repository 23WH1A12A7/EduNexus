package com.edunexus.service;

import com.edunexus.model.Item;
import com.edunexus.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> getItemsByUser(Long userId) {
        return itemRepository.findByOwnerId(userId);
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item updateItem(Long id, Item updatedItem) {
        Item existingItem = itemRepository.findById(id).orElseThrow();
        existingItem.setTitle(updatedItem.getTitle());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setCategory(updatedItem.getCategory());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setStatus(updatedItem.getStatus());
        return itemRepository.save(existingItem);
    }
}
