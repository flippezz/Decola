package Decola02.entity;

import java.util.ArrayList;

public class Empregos {
    private String nome;
    private ArrayList<Profissoes> lstProfissoes = new ArrayList<>();


    public String getNome() {
        return nome;
    }

    public Empregos(String nome) {
        this.nome = nome;
    }

    public ArrayList<Profissoes> getLstProfissoes() {
        return lstProfissoes;
    }

    public void adicionarProfissoes() {
        Profissoes p = new Profissoes("\nCiências Exatas, da Terra e Engenharias \n");
        p.addEmprego(new Empregos("Engenharia Civil"));
        p.addEmprego(new Empregos("Cientista da Computação"));
        p.addEmprego(new Empregos("Engenheiro de Software"));
        p.addEmprego(new Empregos("Arquiteto e Urbanista"));

        Profissoes p1 = new Profissoes("\nCiências Biológicas e da Saúde \n");
        p1.addEmprego(new Empregos("Médico"));
        p1.addEmprego(new Empregos("Enfermeiro"));
        p1.addEmprego(new Empregos("Psicólogo"));
        p1.addEmprego(new Empregos("Biólogo"));
        p1.addEmprego(new Empregos("Nutricionista"));

        Profissoes p2 = new Profissoes("\nCiências Humanas e Sociais \n");
        p2.addEmprego(new Empregos("Advogado"));
        p2.addEmprego(new Empregos("Administrador"));
        p2.addEmprego(new Empregos("Jornalista"));
        p2.addEmprego(new Empregos("Professor"));
        p2.addEmprego(new Empregos("Designer Gráfico"));

        lstProfissoes.add(p);
        lstProfissoes.add(p1);
        lstProfissoes.add(p2);
    }


    public void MostrarProfissoes() {
        System.out.println("Emprego: \n" + nome);
        for (Profissoes p : lstProfissoes) {
            System.out.println(" - " + p.getNome());
        }
    }


}