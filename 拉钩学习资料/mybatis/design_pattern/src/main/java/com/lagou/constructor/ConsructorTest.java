package com.lagou.constructor;

public class ConsructorTest {

    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new ComputerBuilder();
        computerBuilder.installDisplayer("显示器");
        computerBuilder.installMainUnit("主机");
        computerBuilder.installmouse("鼠标");
        computerBuilder.installkeyboard("键盘");

        Computer computer = computerBuilder.getComputer();
        System.out.println(computer);


    }


}
