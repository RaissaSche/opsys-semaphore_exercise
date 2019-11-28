import java.util.Random;

public class Produtor extends Thread {
    // as threads produtoras só podem voltar a produzir depois da thread consumidora
    // ter retirado as informações do buffer.
    private Random random = new Random();
    private GerenciaBuffer gerenciaBuffer;
    private int idThread;

    public Produtor(GerenciaBuffer gerenciaBuffer, int idThread) {
        this.gerenciaBuffer = gerenciaBuffer;
        this.idThread = idThread;
    }

    public void run() {
        int valorProduzido = random.nextInt(11);
        gerenciaBuffer.set(idThread, valorProduzido);
        System.out.print("A thread p" + idThread + " produziu o número " + valorProduzido + "/n");
    }
}