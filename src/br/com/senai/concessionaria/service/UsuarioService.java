package br.com.senai.concessionaria.service;

import br.com.senai.concessionaria.model.Usuario;
import br.com.senai.concessionaria.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioService {

    public static List<Usuario> listarUsuarios() {
        return UsuarioRepository.listarUsuarios();
    }

    public static List<Usuario> listarUsuariosNovos() {
        return UsuarioRepository.listarUsuariosNovos();
    }

    public static void cadastrarUsuario(String nome, String cpf, String telefone, String dataUltimaCompra) {
        Usuario usuario = new Usuario(nome, cpf, telefone, dataUltimaCompra, "Ativo");
        UsuarioRepository.adicionarUsuarioNovo(usuario);
    }

    public static boolean inativarUsuario(String cpf) {
        Optional<Usuario> usuarioOpt = UsuarioRepository.buscarPorCpf(cpf);
        if (usuarioOpt.isEmpty()) {
            return false;
        }
        usuarioOpt.get().setStatus("Inativo");
        return true;
    }

    public static boolean editarNome(String cpf, String novoNome) {
        Optional<Usuario> usuarioOpt = UsuarioRepository.buscarPorCpf(cpf);
        if (usuarioOpt.isEmpty()) {
            return false;
        }
        usuarioOpt.get().setNome(novoNome);
        return true;
    }

    public static boolean editarTelefone(String cpf, String novoTelefone) {
        Optional<Usuario> usuarioOpt = UsuarioRepository.buscarPorCpf(cpf);
        if (usuarioOpt.isEmpty()) {
            return false;
        }
        usuarioOpt.get().setTelefone(novoTelefone);
        return true;
    }

    public static boolean editarDataUltimaCompra(String cpf, String novaData) {
        Optional<Usuario> usuarioOpt = UsuarioRepository.buscarPorCpf(cpf);
        if (usuarioOpt.isEmpty()) {
            return false;
        }
        usuarioOpt.get().setDataUltimaCompra(novaData);
        return true;
    }

    public static boolean editarCpf(String cpfAtual, String novoCpf) {
        Optional<Usuario> usuarioOpt = UsuarioRepository.buscarPorCpf(cpfAtual);
        if (usuarioOpt.isEmpty()) {
            return false;
        }
        usuarioOpt.get().setCpf(novoCpf);
        return true;
    }

    public static boolean existeUsuario(String cpf) {
        return UsuarioRepository.buscarPorCpf(cpf).isPresent();
    }
}
