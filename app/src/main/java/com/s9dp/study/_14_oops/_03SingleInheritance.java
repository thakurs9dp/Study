package com.s9dp.study._14_oops;

public class _03SingleInheritance {

    void shown() {

    }

}

class ASingleInharitance extends _03SingleInheritance {

    void eat() {
        System.out.print("This is child class method");
    }

    public static void main(String[] arg) {
        ASingleInharitance singleInheritance = new ASingleInharitance();
        singleInheritance.shown();
    }

}


