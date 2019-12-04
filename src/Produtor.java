import java.util.concurrent.Semaphore;

public class Produtor extends Thread {
    Semaphore semaforoProducao, semaforoConsumo;
    int b, id;

    public Produtor(int id) throws InterruptedException {
        this.id = id;
        //Dois semáforos para garantir que um produtor não vai produzir enquanto o consumidor estiver ocupado, e vice-versa
        semaforoProducao = new Semaphore(1);
        semaforoConsumo = new Semaphore(1);
        //começa trancado porque não ter nada no buffer
        semaforoConsumo.acquire();
    }

    public void run() {
        while (true) {
            try {
                semaforoProducao.acquire();
                b = (int) (Math.random() * 11);
                System.out.println("Produtor " + id + " produziu: " + b);
                semaforoConsumo.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Semaphore getSemaforoProducao() {
        return semaforoProducao;
    }

    public Semaphore getSemaforoConsumo() {
        return semaforoConsumo;
    }

    public int getB() {
        return b;
    }

    public int getIdProdutor() {
        return id;
    }
}
