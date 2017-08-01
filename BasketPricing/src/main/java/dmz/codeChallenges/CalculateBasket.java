package dmz.codeChallenges;

import dmz.codeChallenges.model.Basket;
import dmz.codeChallenges.model.BasketItem;
import dmz.codeChallenges.model.SpecialOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CalculateBasket {
    
    private final List<SpecialOffer> deals;
    private Basket basket;

    CalculateBasket(Basket basket, List<SpecialOffer> availableDeals) {
        this.basket = basket;
        this.deals = availableDeals;
    }

    // This method aims to guarantee the execution order;
    // EvaluateDiscount() must be executed before calculating CalculateTotal()
    void PerformCalculation() {
        this.EvaluateDiscount();
        this.CalculateSubTotal();
        this.CalculateTotal();
    }
    
    /******************************************************************
    * Discount evaluating:
     * if the conditional and target item from the deal were selected
     * the discount can be applied
    *******************************************************************/
    void EvaluateDiscount() {
        List<SpecialOffer> validDeals = new ArrayList<>();

        for (SpecialOffer deal : deals) {
            Optional<BasketItem> itemCond = this.basket
                                                .getItems()
                                                .stream()
                                                .filter(i -> i.getId().equals(deal.getItemCond()))
                                                .findFirst();
            if (itemCond.isPresent()) {
                Optional<BasketItem> itemTarget = this.basket
                                                      .getItems()
                                                      .stream()
                                                      .filter(i -> i.getId().equals(deal.getItemTarget()))
                                                      .findFirst();
                if (!itemTarget.isPresent())
                    continue;
                
                if (this.ApplyDiscount(itemCond.get(), itemTarget.get(), deal)) {
                    validDeals.add(deal);
                }
            }
        }
        this.basket.setDeals(validDeals);
    }

    /******************************************************************
     *  Discount calculation:
     *  if the deal's conditional quantity is 0 (no condition)
     *   - the discount is applied for every selected target item
     *  else if the quantity of selected target items is
     *  equal or higher than the conditional quantity
     *   - the discount coefficient is calculated and applied
     *   to the gross value
     ******************************************************************/
    Boolean ApplyDiscount(BasketItem itemCond, BasketItem itemTarget, SpecialOffer deal) {
        if (deal.getCondQty().equals(0)) {
            itemTarget.setDealApplied(deal.getId());
            itemTarget.setValueOff(
                    deal.getDiscount() * itemTarget.getUnitPrice() * itemTarget.getQuantity());
            return true;
        } else if (itemCond.getQuantity() >= deal.getCondQty()) {
            int discCoef =
                    itemTarget.getQuantity() -
                    ((itemCond.getQuantity() / deal.getCondQty()) % itemTarget.getQuantity());
            itemTarget.setDealApplied(deal.getId());
            itemTarget.setValueOff(deal.getDiscount() * itemTarget.getUnitPrice() * discCoef);
            return true;
        }
        return false;
    }
    
    // Subtotal value is the sum of gross cost of all items selected
    void CalculateSubTotal() {
        Double result = this.basket
                            .getItems()
                            .stream()
                            .mapToDouble(i ->
                               Optional.ofNullable(i.getUnitPrice()).orElse(0d) *
                               Optional.ofNullable(i.getQuantity()).orElse(0))
                            .sum();
        this.basket.setSubtotal(result);
    }

    // Total value is the sum of { gross cost - discount } of all items selected
    void CalculateTotal() {
         Double result = this.basket
                             .getItems()
                             .stream()
                             .mapToDouble(i ->
                               ( Optional.ofNullable(i.getUnitPrice()).orElse(0d) *
                                 Optional.ofNullable(i.getQuantity()).orElse(0))
                               - Optional.ofNullable(i.getValueOff()).orElse(0d))
                             .sum();
        this.basket.setTotal(result);
    }
}
