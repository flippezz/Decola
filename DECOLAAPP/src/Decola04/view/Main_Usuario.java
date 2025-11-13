package Decola04.view;

import Decola01.dao.UsuarioDAO;
import Decola02.entity.Usuario;
import java.util.Scanner;

public class Main_Usuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario usuario = new Usuario(nome, email, senha);
        UsuarioDAO dao = new UsuarioDAO();
        dao.inserir(usuario);

        sc.close();
    }
}
