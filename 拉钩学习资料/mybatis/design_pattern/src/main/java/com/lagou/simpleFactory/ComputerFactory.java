package com.lagou.simpleFactory;

public class ComputerFactory {

    public static Computer createComputer(String type){
        Computer computer =null;
        switch (type){
            case "lenovo":
                computer = new LenovoComputer();
            case "hp":
                computer = new HpComputer();
        }

        return  computer;
    }

}
