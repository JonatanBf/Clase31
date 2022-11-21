package com.example.Usuarios.service;

import com.example.Usuarios.entidades.Usuarios;
import com.example.Usuarios.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuariosRepository repository;

    public List<Usuarios> listar(){
        return repository.findAll();
    }

    public String guardar(Usuarios u){
        if (repository.save(u)!= null){
            return "Se guardo correctamente";
        }else {
            return "Error, muchos errores";
        }
    }

    public Usuarios buscarId(Integer id) {
            return  repository.findById(id).get();
        }

    public void  eliminar(Integer id){
        repository.deleteById(id);
    }


}
