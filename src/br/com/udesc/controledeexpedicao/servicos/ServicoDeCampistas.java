package br.com.udesc.controledeexpedicao.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.udesc.controledeexpedicao.dao.CampistasDAO;
import br.com.udesc.controledeexpedicao.dao.MochilasDAO;
import br.com.udesc.controledeexpedicao.modelos.Campista;

public class ServicoDeCampistas {

    private ArrayList<Campista> campistas;
    private CampistasDAO campistasDAO;
    private MochilasDAO mochilasDAO;
    private Scanner scanner;

    public ServicoDeCampistas (Scanner scanner, CampistasDAO campistasDAO, MochilasDAO mochilasDAO) {
        this.campistasDAO = campistasDAO;
        this.mochilasDAO = mochilasDAO;
    	campistas = new ArrayList<>();
    	this.scanner = scanner;
    }
    
    public void addCampista(double capacidadeMochila, String nome, String cpf) {
    	Campista campista = new Campista(capacidadeMochila, nome, cpf);
    	campistas.add(campista);
    	try {
			campistasDAO.inserir(campista);
            mochilasDAO.inserir(campista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    
    public ArrayList<Campista> getTodosOsCampistas() {
    	return this.campistas;
    }

    public void imprimeCampistas() {
        for (Campista campista : campistas) {
            System.out.println(campista.getNome());
        }
    }
}
