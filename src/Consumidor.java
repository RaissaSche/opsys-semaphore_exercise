import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Consumidor extends Thread {
    private List<Produtor> produtores;
    private List<Integer> valoresProduzidos;

    public Consumidor() {
        valoresProduzidos = new ArrayList<Integer>();
    }

    public void run() {
        try {
            while (true) {
                //garante a ordem de leitura: primeiro de p0 (bo) e depois de p1(b1)
                for (Produtor p : this.produtores) {
                    //Só para ficar mais legível os outputs
                    TimeUnit.MILLISECONDS.sleep(1000);
                    p.getSemaforoConsumo().acquire();
                    valoresProduzidos.add(p.getB());
                    System.out.println("Consumiu do processo " + p.getIdProdutor());
                    System.out.println(valoresProduzidos);
                    p.getSemaforoProducao().release();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setProdutores(List<Produtor> produtores) {
        this.produtores = produtores;
    }
}
