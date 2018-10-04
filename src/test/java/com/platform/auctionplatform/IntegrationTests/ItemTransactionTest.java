package com.platform.auctionplatform.IntegrationTests;

import com.platform.auctionplatform.Database.DbContext;
import com.platform.auctionplatform.Models.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemTransactionTest {

    @Autowired
    private DbContext db;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test() {
        assertTrue(true);
    }

    @Test
    public void testInsertGeneratesId(){


        //Create object
        Item item = new Item();
        item.setDescription("Test Description");

        //Make sure object has no id
        assertEquals(0, item.getItemId());

        db.items().save(item);

        assertTrue(item.getItemId() > 0);

    }
}