package dmz.codeChallenges.model;

import java.util.List;

public class Basket {
    private List<BasketItem> Items;
    private List<SpecialOffer> Deals;
    private Double Subtotal;
    private Double Total;
    
    public List<BasketItem> getItems() {
        return Items;
    }
    public void setItems(List<BasketItem> items) {
        Items = items;
    }
    public List<SpecialOffer> getDeals() {
        return Deals;
    }
    public void setDeals(List<SpecialOffer> deals) {
        Deals = deals;
    }
    public Double getSubtotal() {
        return Subtotal;
    }
    public void setSubtotal(Double subtotal) {
        Subtotal = subtotal;
    }
    public Double getTotal() {
        return Total;
    }
    public void setTotal(Double total) {
        Total = total;
    }

}
