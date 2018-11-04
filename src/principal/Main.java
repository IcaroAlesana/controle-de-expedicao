package principal;

import modelos.KitBasico;
import modelos.Mantimento;
import repositorios.RepositorioDeKitsBasicos;
import repositorios.RepositorioDeMantimentos;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        RepositorioDeMantimentos repM = new RepositorioDeMantimentos();
        ArrayList<Mantimento> mantimentos = repM.getTodosOsMantimentos();

        RepositorioDeKitsBasicos repK = new RepositorioDeKitsBasicos();
        ArrayList<KitBasico> kitsBasicos = repK.getTodosOsKits();
    }
}
