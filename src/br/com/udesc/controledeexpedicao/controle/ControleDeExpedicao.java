package br.com.udesc.controledeexpedicao.controle;

import java.util.ArrayList;

import br.com.udesc.controledeexpedicao.modelos.Campista;
import br.com.udesc.controledeexpedicao.servicos.ServicoDeCampistas;

public class ControleDeExpedicao {
    private int dias;
    
    private ServicoDeCampistas servicoDeCampistas;

    public ControleDeExpedicao(ServicoDeCampistas servicoDeCampistas) {
        
        this.servicoDeCampistas = servicoDeCampistas;
    }
    
    public void iniciar() {
    	
    }


    public void mantimentosSuficientesGrupo() {
        int espacoEmBarracas = 0;
        ArrayList<Campista> campistas = servicoDeCampistas.getTodosOsCampistas();
        for (Campista campista : campistas) {
            campista.mantimentosSuficientesIndividual(dias);
            if (campista.temBarraca()) {
                espacoEmBarracas += campista.espacoNaBarraca();
            }
        }
        if(espacoEmBarracas < campistas.size()){
            System.out.println("O grupo possui " + espacoEmBarracas + "lugares em barracas, para" + campistas.size() + "campistas.");
        }
    }
    
    
}
