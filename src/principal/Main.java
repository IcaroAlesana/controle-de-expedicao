package principal;

import modelos.Mantimento;
import repositorios.RepositorioDeMantimentos;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        RepositorioDeMantimentos rep = new RepositorioDeMantimentos();
        ArrayList<Mantimento> mantimentos = rep.getTodosOsMantimentos();
    }
}
