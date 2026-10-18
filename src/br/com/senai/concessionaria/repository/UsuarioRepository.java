package br.com.senai.concessionaria.repository;

import br.com.senai.concessionaria.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final List<Usuario> usuariosNovos = new ArrayList<>();

    static {
        carregarPreCadastrados();
    }

    private static void carregarPreCadastrados() {
        adicionarUsuario(new Usuario("João", "1", "(11) 91234-5678", "15/06/2024", "Ativo"));
        adicionarUsuario(new Usuario("Fabio", "2", "(21) 99876-5432", "10/05/2024", "Ativo"));
        adicionarUsuario(new Usuario("H.Foud CU", "3", "(31) 93456-7890", "20/04/2024", "Ativo"));
    }

    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static void adicionarUsuarioNovo(Usuario usuario) {
        usuariosNovos.add(usuario);
    }

    public static List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public static List<Usuario> listarUsuariosNovos() {
        return new ArrayList<>(usuariosNovos);
    }

    public static Optional<Usuario> buscarPorCpf(String cpf) {
        Optional<Usuario> encontrado = usuarios.stream()
                .filter(u -> cpf.equals(u.getCpf()))
                .findFirst();
        if (encontrado.isPresent()) {
            return encontrado;
        }
        return usuariosNovos.stream()
                .filter(u -> cpf.equals(u.getCpf()))
                .findFirst();
    }
}
