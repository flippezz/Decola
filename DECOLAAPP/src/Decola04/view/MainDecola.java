package Decola04.view;

import Decola02.entity.*;
import Decola01.dao.*;

import java.util.List;
import java.util.Scanner;

public class MainDecola {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UsuarioDAO2 usuarioDAO = new UsuarioDAO2();
        ProfissoesDAO profissaoDAO = new ProfissoesDAO();
        EmpregoDAO empregoDAO = new EmpregoDAO();
        TesteVocacionalDAO testeDAO = new TesteVocacionalDAO();

        int opt;
        do {
            System.out.println("\n=== MENU DECOLA ===");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Explorar profissões e empregos");
            System.out.println("3 - Teste Vocacional");
            System.out.println("4 - Listar Usuários do Banco");
            System.out.println("5 - Alterar Usuário");
            System.out.println("6 - Deletar Usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    Usuario u = new Usuario(nome, email, senha);
                    usuarioDAO.inserir(u);
                    System.out.println("Usuário cadastrado com sucesso no banco!");
                }
                case 2 -> {
                    List<Profissoes> profs = profissaoDAO.listar();
                    System.out.println("\n=== Explorar Profissões ===");
                    for (Profissoes p : profs) {
                        System.out.println("\nCategoria: " + p.getNome());
                        List<Empregos> empregos = empregoDAO.listarPorProfissao(p.getId());
                        for (Empregos e : empregos) {
                            System.out.println(" - " + e.getNome());
                        }
                    }
                }
                case 3 -> {
                    System.out.println("\n=== Teste Vocacional ===");
                    TesteVocacional teste = new TesteVocacional();
                    teste.Perguntas();
                }
                case 4 -> {
                    List<Usuario> usuarios = usuarioDAO.listar();
                    System.out.println("\n=== Usuários Cadastrados no Banco ===");
                    for (Usuario u : usuarios) {
                        System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Email: " + u.getEmail());
                    }
                }
                case 5 -> { // Alterar usuário
                    System.out.print("Digite o ID do usuário que deseja alterar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Novo email: ");
                    String email = sc.nextLine();
                    System.out.print("Nova senha: ");
                    String senha = sc.nextLine();

                    Usuario u = new Usuario(id, nome, email, senha);
                    usuarioDAO.atualizar(u); // precisamos criar esse método no DAO
                    System.out.println("Usuário atualizado com sucesso!");
                }
                case 6 -> {
                    System.out.print("Digite o ID do usuário que deseja deletar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    usuarioDAO.deletar(id); // precisamos criar esse método no DAO
                    System.out.println("Usuário deletado com sucesso!");
                }
                case 0 -> System.out.println("Saindo... Obrigado por usar o Decola!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opt != 0);

        sc.close();
    }
}
