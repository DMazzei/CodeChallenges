package dmz.codeChallenges.model;

public class SpecialOffer {
    private Integer id;
    private Integer itemCond;
    private Integer condQty;
    private Integer itemTarget;
    private Double discount;
    private String description;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getItemCond() {
        return itemCond;
    }
    public void setItemCond(Integer itemCond) {
        this.itemCond = itemCond;
    }
    public Integer getCondQty() {
        return condQty;
    }
    public void setCondQty(Integer condQty) {
        this.condQty = condQty;
    }
    public Integer getItemTarget() {
        return itemTarget;
    }
    public void setItemTarget(Integer itemTarget) {
        this.itemTarget = itemTarget;
    }
    public Double getDiscount() {
        return discount;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
