# sisop-semaforos
Um estudo de problema produtor/consumidor com semáforos

Enunciado do exercício:

"Escreva um programa concorrente formado por três threads: uma consumidora (c) e duas produtoras (p0 e p1), que executam um loop infinito. A thread consumidora recebe informações (um valor inteiro) da thread p0 no buffer b0 e da thread p1 no buffer b1 (primeiro consome de b0 e depois consome de b1). Os buffers b0 e b1 possuem capacidade de armazenar um único elemento. A thread consumidora só pode consumir se existirem informações no buffer, e as threads produtoras só podem voltar a produzir depois da thread consumidora ter retirado as informações do buffer. Utilize semáforos para sincronização."
