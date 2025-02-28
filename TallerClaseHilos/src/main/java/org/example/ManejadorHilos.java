package org.example;

public class ManejadorHilo implements  Runnable{


    BoundedSemaphore semaphore = new BoundedSemaphore(1);

    Thread hiloServicio4;
    Thread hiloServicio5;

    String p;
    boolean runHilo;

    public ManejadorHilo() {
        this.runHilo = true;
    }

    public void starHiloServicio4(String P) {
        this.p = p;
        this.runHilo = true;

        hiloServicio4 = new Thread(this);
        hiloServicio4.start();

    }


    public void starHiloServicio5() {
        this.runHilo = true;

        hiloServicio5 = new Thread(this);
        hiloServicio5.start();
    }




    @Override
    public void run() {
        long tac = 0;
        long tf = 0

        long tiempoInicio = System.currentTimeMillis();
        while (tac < 180001){
            while (tf < 60001){
                Thread hiloEjecucion = hiloServicio5;
                try {
                    semaphore.ocupar();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                tf = System.currentTimeMillis() - tiempoInicio;
            }
            tac = System.currentTimeMillis() - tiempoInicio;
        }
    }

    private void liberarEjecucion() {
        try {
            semaphore.liberar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void ejecutarHiloServicio4() {
        boolean runHilo4 = true;
        int i = 1;
        while(runHilo4){
            try {
                Thread.sleep(1000);

                System.out.println("Resultado = "+ valorEntrada +"*"+i+" = "+ valorEntrada*i);

                if(i == 15){
                    runHilo4 = false;
                    i = 0;
                }
                i++;

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void ejeuctarHiloServicio5() {
        int j = 0;
        boolean runHilo5 = true;
        while(runHilo5){
            try {
                Thread.sleep(1200);
                valorEntrada = valorEntrada + valorEntrada;
                System.out.println("Resultado modificado = "+ valorEntrada);
                if(j == 15){
                    runHilo5 = false;
                    j = 0;
                }
                j++;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
