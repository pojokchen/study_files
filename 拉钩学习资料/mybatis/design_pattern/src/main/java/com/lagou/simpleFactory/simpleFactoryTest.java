package com.lagou.simpleFactory;

public class simpleFactoryTest {

    public static void main(String[] args) {
        Computer computer = ComputerFactory.createComputer("hp");
        computer.start();

    }
}
