package dmz.codeChallenges.factory;

import dmz.codeChallenges.util.JsonHelper;
import dmz.codeChallenges.model.BasketItem;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasketFactory {

    private final List<BasketItem> selectedItems;

    public BasketFactory(String itemsInput) throws IOException, URISyntaxException {
        List<BasketItem> availableItems =
                JsonHelper.LoadBasketItems(getClass().getResource("/data/goods.json").toURI());
        this.selectedItems = new ArrayList<>();

        String[] items = itemsInput.split("\\s");
        for (String itemName : items){
            Optional<BasketItem> newItem = availableItems
                                               .stream()
                                               .filter(i -> i.getName().toUpperCase().equals(itemName.toUpperCase()))
                                               .findFirst();

            if (newItem.isPresent()){
                Optional<BasketItem> item = this.selectedItems
                                                .stream()
                                                .filter(s -> s.getId().equals(newItem.get().getId()))
                                                .findFirst();
                if (item.isPresent()){
                    item.get().setQuantity(item.get().getQuantity() + 1);
                } else {
                    newItem.get().setQuantity(1);
                    newItem.get().setValueOff(0d);
                    this.selectedItems.add(newItem.get());
                }
            }
        }
    }

    public List<BasketItem> getSelectedItems() {
        return selectedItems;
    }
}
