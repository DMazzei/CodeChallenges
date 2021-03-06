package dmz.codeChallenges.factory;

import dmz.codeChallenges.model.BasketItem;
import dmz.codeChallenges.util.JsonHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({JsonHelper.class})
public class BasketFactoryTest {

    @Before
    public void setup() throws Exception {

        List<BasketItem> fakeItemList = new ArrayList<>();
        BasketItem fakeItem1 = new BasketItem();
        fakeItem1.setId(101);
        fakeItem1.setName("Soup");
        fakeItem1.setUnitPrice(0.65d);
        fakeItemList.add(fakeItem1);
        BasketItem fakeItem2 = new BasketItem();
        fakeItem2.setId(103);
        fakeItem2.setName("Milk");
        fakeItem2.setUnitPrice(1.3d);
        fakeItemList.add(fakeItem2);

        MockitoAnnotations.initMocks(this);
        PowerMockito.mockStatic(JsonHelper.class);
        when(JsonHelper.LoadBasketItems(any(URI.class))).thenReturn(fakeItemList);
    }

    @Test
    public void BasketFactoryConstructorShouldProvideSelectedItems() throws Exception {
        System.out.println("BasketFactoryConstructorShouldProvideSelectedItems");

        String selectedItem = "Milk";
        Integer expectedId = 103;

        BasketFactory underTest = new BasketFactory(selectedItem);

        assertNotNull("Item list should not be null", underTest);
        assertFalse("Item list should not be empty", underTest.getSelectedItems().isEmpty());
        assertEquals("Id value is incorrect", expectedId, underTest.getSelectedItems().get(0).getId());
    }
}
