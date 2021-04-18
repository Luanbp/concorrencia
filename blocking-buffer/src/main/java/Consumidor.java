import java.util.Random;

public class Consumidor implements Runnable {

    private static Random gerador = new Random();
    private Buffer localizacaoCompartilhada;

    public Consumidor(Buffer compartilhado){
        localizacaoCompartilhada = compartilhado;
    }

    public void run() {

        int soma = 0;
        for(int contador = 1; contador <= 10; contador++){
            try {
                Thread.sleep(gerador.nextInt(3000));
                soma += localizacaoCompartilhada.get();
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.printf("\n%s\n%s\n",  "Valores lidos por consumidor totalizam: " + soma, "Fim do Consumidor.");
    }
}
