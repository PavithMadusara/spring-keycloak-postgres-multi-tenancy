package com.aupma.postgresstenant.rest;

import com.aupma.postgresstenant.entity.Item;
import com.aupma.postgresstenant.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavith Madusara
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/item", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemResource {

    private final ItemService itemService;

    @PostMapping
    public void createItem() {
        log.info("Create Item");
        Item item = new Item();
        item.setName("Item 1");
        item.setDescription("Item 1 Description");
        itemService.createItem(item);
    }

    @GetMapping
    public Integer[] getItems() {
        log.info("Get Items");
        return itemService.findAll().stream().map(Item::getId).toArray(Integer[]::new);
    }

}
