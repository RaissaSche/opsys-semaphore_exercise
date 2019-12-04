import java.util.ArrayList;
import java.util.List;

public class ImplementacaoProdutorConsumidor {

    public static void main(String[] args) {
        try {
            Produtor p0 = new Produtor(0);
            Produtor p1 = new Produtor(1);
            Consumidor c = new Consumidor();

            List<Produtor> produtores = new ArrayList<>();
            produtores.add(p0);
            produtores.add(p1);

            for (Produtor produtor : produtores) {
                produtor.start();
            }

            c.setProdutores(produtores);
            c.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}