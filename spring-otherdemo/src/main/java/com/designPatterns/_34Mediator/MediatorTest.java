package com.designPatterns._34Mediator;

public class MediatorTest {

    public static void main(String[] args) {
        MediatorStructure mediator = new MediatorStructure();

        // 房主和房客只需要知道中介机构即可
        HouseOwner houseOwner = new HouseOwner("Tom", mediator);
        HouseRenter houseRenter = new HouseRenter("Cat", mediator);

        // 中介结构要知道房主和房客
        mediator.setHouseOwner(houseOwner);
        mediator.setHouseRenter(houseRenter);

        houseRenter.contact("Do you have some house?");
        houseOwner.contact("Yes, I have many house!");
    }
}
