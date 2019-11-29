public class ImplementacaoProdutorConsumidor {
    //Escreva um programa concorrente formado por três threads:
    //uma​ consumidora(​c​)e duas produtoras​(​p0 e​ p1​), que executam um loop infinito.
    // A thread consumidora recebe informações(um valor inteiro)da thread ​p0 no buffer ​b0
    // e da thread ​p1 no buffer ​b1​(primeiro consome de ​b0 e depois consome de ​b1​).
    // Os buffers ​b0 e​ b1 possuem capacidade de armazenar um único elemento.
    // A thread consumidora só pode consumir se existirem informações no buffer,
    // e as threads produtoras só podem voltar a produzir depois da thread consumidora
    // ter retirado as informações do buffer.
    // Utilize semáforos para sincronização.
    //https://www.devmedia.com.br/trabalhando-com-threads-em-java/28780
    //https://brizeno.wordpress.com/2011/09/25/praticando-concorrencia-em-java-semaforos/
    //https://sites.google.com/site/jessicaso2011/codigo-produtor-consumidor-com-semaforos
    //http://www.dsc.ufcg.edu.br/~jacques/cursos/map/html/threads/sincronizacao.html

    public static void main(String[] args) {
        GerenciaBuffer gerenciaBuffer = new GerenciaBuffer(1);
        Produtor p0 = new Produtor(gerenciaBuffer, 0);
        Produtor p1 = new Produtor(gerenciaBuffer, 1);
        Consumidor c = new Consumidor(gerenciaBuffer, 2);

        p0.start();
        p1.start();
        c.start();
    }
}