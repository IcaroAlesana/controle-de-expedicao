package principal;

import modelos.KitBasico;
import modelos.Mantimento;
import modelos.Utilidade;
import repositorios.RepositorioDeKitsBasicos;
import repositorios.RepositorioDeMantimentos;
import repositorios.RepositorioDeUtilidades;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        RepositorioDeMantimentos repM = new RepositorioDeMantimentos();
        ArrayList<Mantimento> mantimentos = repM.getTodosOsMantimentos();

        RepositorioDeKitsBasicos repK = new RepositorioDeKitsBasicos();
        ArrayList<KitBasico> kitsBasicos = repK.getTodosOsKits();

        RepositorioDeUtilidades repU = new RepositorioDeUtilidades();
        ArrayList<Utilidade> utilidades = repU.getTodasAsUtilidades();
    }
}
