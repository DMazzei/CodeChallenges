package dmz.codeChallenges.model;

import dmz.codeChallenges.util.UnitType;

public class BasketItem {
    private Integer id;
    private String name;
    private Double unitPrice;
    private UnitType unitType;
    private Integer quantity;
    private Integer dealApplied;
    private Double valueOff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getDealApplied() {
        return dealApplied;
    }

    public void setDealApplied(Integer dealApplied) {
        this.dealApplied = dealApplied;
    }

    public Double getValueOff() {
        return valueOff;
    }

    public void setValueOff(Double valueOff) {
        this.valueOff = valueOff;
    }
}
