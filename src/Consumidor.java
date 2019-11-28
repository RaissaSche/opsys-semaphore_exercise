import java.util.ArrayList;

// A thread consumidora recebe informações(um valor inteiro)da thread ​p0 no buffer ​b0
// e da thread ​p1 no buffer ​b1​(primeiro consome de ​b0 e depois consome de ​b1​).
// Os buffers ​b0 e​ b1 possuem capacidade de armazenar um único elemento.
// A thread consumidora só pode consumir se existirem informações no buffer.

public class Consumidor extends Thread {
    private GerenciaBuffer gerenciaBuffer;
    private int idThread;
    private ArrayList<Integer> valoresConsumidos = new ArrayList();

    public Consumidor(GerenciaBuffer gerenciaBuffer, int idThread) {
        this.gerenciaBuffer = gerenciaBuffer;
        this.idThread = idThread;
    }

    public void run() {
        valoresConsumidos.add(gerenciaBuffer.get(idThread));
        System.out.print("Valores consumidos: " + valoresConsumidos + "/n");
    }
}
