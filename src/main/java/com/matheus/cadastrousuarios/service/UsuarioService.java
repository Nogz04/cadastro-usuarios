package com.matheus.cadastrousuarios.service;


import com.matheus.cadastrousuarios.dto.UsuarioRequestDTO;
import com.matheus.cadastrousuarios.dto.UsuarioResponseDTO;
import com.matheus.cadastrousuarios.model.Usuario;
import com.matheus.cadastrousuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setCPF(dto.cpf());

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuarioSalvo.getId(), usuarioSalvo.getNome(), usuarioSalvo.getEmail(), usuarioSalvo.getCPF());
    }

    public List<UsuarioResponseDTO> listarTodos(){
        return usuarioRepository.findAll().stream().map(u -> new UsuarioResponseDTO(u.getId(), u.getNome(), u.getEmail(), u.getCPF())).collect(Collectors.toList());
    }

    public UsuarioResponseDTO buscarPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCPF());
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setCPF(dto.cpf());

        Usuario atualizado = usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCPF());
    }

    public void deletar(Long id){
        usuarioRepository.deleteById(id);
    }

}
