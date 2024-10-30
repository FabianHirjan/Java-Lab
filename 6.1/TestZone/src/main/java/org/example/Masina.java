package org.example;

public class Masina {

    private static int hp = 250;

    public Masina() {
        hp++;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int div(int a, int b){
        try{
            a = a / b;
        }
        catch (ArithmeticException e){
            //System.out.println("Imparti la 0");
            System.err.println("Imparti la 0");
        }
        return a;
    }
}
