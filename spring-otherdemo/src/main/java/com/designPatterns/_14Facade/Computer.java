package com.designPatterns._14Facade;

public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    Computer() {
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup() {
        System.out.println("start the computer!");
        cpu.startUp();
        memory.startUp();
        disk.startUp();
        System.out.println("start computer finished!");
    }

    public void shutdown() {
        System.out.println("begin to close the computer!");
        cpu.shutDown();
        memory.shutDown();
        disk.shutDown();
        System.out.println("computer closed!");
    }
}
