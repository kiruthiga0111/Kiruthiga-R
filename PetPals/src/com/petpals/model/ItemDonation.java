package com.petpals.model;

public class ItemDonation extends Donation {
    private String itemType;

    public ItemDonation(String donorName, double amount, String itemType) {
        super(donorName, amount);
        this.itemType = itemType;
    }

    public String getItemType() {
        return itemType;
    }

    @Override
    public void recordDonation() {
        System.out.println("Item donation recorded: " + donorName + " donated " + itemType + " worth $" + amount);
    }
}
