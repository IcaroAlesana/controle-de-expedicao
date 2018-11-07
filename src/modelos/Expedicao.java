package modelos;

import java.util.ArrayList;

public class Expedicao {
    private ArrayList<Campista> campistas;
    private int dias;

    public Expedicao() {
        campistas = new ArrayList<>();
    }


    public void mantimentosSuficientesGrupo() {
        for (Campista campista : campistas) {
            campista.mantimentosSuficientesIndividual(dias);
        }
    }
}
