package Decola02.entity;

import java.util.ArrayList;

public class Profissoes {
    private int id;
    private String nome;
    private ArrayList<Empregos> lstEmpregos = new ArrayList<>();


    public Profissoes(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Empregos> getLstEmpregos() {
        return lstEmpregos;
    }

    public void addEmprego(Empregos e) {
        lstEmpregos.add(e);
    }
    public void Mostrar() {
        System.out.println(nome);
        System.out.println("Profissões: \n");
        for (Empregos e : lstEmpregos) {
            System.out.println(" - " + e.getNome());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
