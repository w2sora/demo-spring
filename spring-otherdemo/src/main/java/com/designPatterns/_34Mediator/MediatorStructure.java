package com.designPatterns._34Mediator;

public class MediatorStructure extends Mediator {
    private HouseOwner houseOwner;
    private HouseRenter houseRenter;

    public HouseOwner getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(HouseOwner houseOwner) {
        this.houseOwner = houseOwner;
    }

    public HouseRenter getHouseRenter() {
        return houseRenter;
    }

    public void setHouseRenter(HouseRenter houseRenter) {
        this.houseRenter = houseRenter;
    }

    @Override
    public void contact(String message, Person person) {
        if (person instanceof HouseOwner) {
            houseRenter.getMessage(message);
        } else if (person instanceof HouseRenter) {
            houseOwner.getMessage(message);
        }
    }
}
