package com.s9dp.study._14_oops;

abstract class _07Abstract {
    abstract void start();

    void shownFun() {
        System.out.print("Hello This parent Abstract Method");
    }
}

class Abstract_A extends _07Abstract {

    @Override
    void start() {
        System.out.print("Abstract A Method call");
    }

}

class Abstract_B extends _07Abstract {

    @Override
    void start() {

    }

}


class Abstract_Main {

    public static void main(String[] arg) {

        _07Abstract obj = new Abstract_A();
        obj.shownFun();
        obj.start();

    }
}
