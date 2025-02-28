package org.example;

public class Hilo2 extends Thread{
    private int n;
    private int x;

    public Hilo2(int n) {
        this.n = n;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(800);
            setX(sumaRecursiva(0));
            System.out.println("La suma recursiva es: "+getX());
        }catch(InterruptedException e){

        }

    }

    public int sumaRecursiva(int indice){
        if(indice == getN()){
            return indice;
        }else{
            return sumaRecursiva(indice + 1)+indice;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
