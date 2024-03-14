import java.util.Objects;
import java.util.Random;

public class Luta implements LutaRepository{
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds(){
        return rounds;
    }

    public void setRounds(int rounds){
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    @Override
    public void marcarLuta(Lutador l1, Lutador l2) {
        if((l1.getCategoria().equals(l2.getCategoria())) && !Objects.equals(l1, l2)){
            this.aprovada = true;
            this.desafiado = l1;
            this.desafiante = l2;
            System.out.println("Luta marcada!");
        } else{
            this.aprovada = false;
            this.desafiado = null;
            this.desafiante = null;
            if(!Objects.equals(l1.getCategoria(), l2.getCategoria())){
                System.out.println("Luta não marcada, pois não pertencem a mesma categoria.");
            } else{
                System.out.println("Luta não marcada, pois são o mesmo lutador.");
            }
        }
    }

    @Override
    public void lutar() {
        if(this.aprovada){
            System.out.println("______________DESAFIADO_____________");
            desafiado.apresentar();
            System.out.println();
            System.out.println("_____________DESAFIANTE_____________");
            desafiante.apresentar();
            System.out.println();
            Random random = new Random();
            int vencedor = random.nextInt(3);
            switch (vencedor){
                case 0:
                    System.out.println("Empatou!");
                    desafiado.empatarLuta();
                    desafiante.empatarLuta();
                    break;
                case 1:
                    System.out.println("Vitória do " + desafiado.getNome());
                    desafiado.ganharLuta();
                    desafiante.perderLuta();
                    break;
                case 2:
                    System.out.println("Vitória do " + desafiante.getNome());
                    desafiado.perderLuta();
                    desafiante.ganharLuta();
                    break;
            }
        } else{
            System.out.println("Luta não pode acontecer");
        }
    }
}
