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

    public Campista getCampistaPorNome(String nome) {
        for (Campista campista : campistas) {
            String nomeDoCampista = campista.getNome();
            if (nome.equals(nomeDoCampista)) {
                return campista;
            }
        }
        return null;
    }

    public Campista getCampistaPorCPF(String cpf) {
        for (Campista campista : campistas) {
            String cpfDoCampista = campista.getCpf();
            if (cpf.equals(cpfDoCampista)) {
                return campista;
            }
        }
        return null;
    }
}
