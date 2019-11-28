import java.util.concurrent.Semaphore;

public class GerenciaBuffer {
    //foi escolhida a classe Integer por aceitar que a variável fique nula, ou seja, vazia
    private static Integer[] b = {null, null};
    private int numThread; //número de threads que pode acessar o recurso ao mesmo tempo
    private Semaphore semaforo = new Semaphore(numThread);

    public GerenciaBuffer(int numThread) {
        this.numThread = numThread;
    }

    public Integer get(int idThread) {
        if (idThread < 2) {
            //identifica o buffer correto de acordo com o produtor
            while (b[idThread] != null) { //indisponível
                try {
                    semaforo.acquire();
                    //esperar pelo valor do produtor
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaforo.release();
                }
            }
            return b[idThread];
        }
        return null;
    }

    public void set(int idThread, int valorProduzido) {
        if (idThread < 2) {
            //identifica o buffer correto de acordo com o produtor
            while (b[idThread] == null) { //disponível
                try {
                    semaforo.acquire();
                    //esperar pelo consumidor pegar o valor
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaforo.release();
                }

                b[idThread] = valorProduzido;
            }
        }
    }
}
