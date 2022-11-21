package com.example.Usuarios.controller;

import com.example.Usuarios.entidades.Usuarios;
import com.example.Usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Usuarios>> listar(){
        return ResponseEntity.ok(usuarioService.listar());
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardar(@RequestBody Usuarios u){
        ResponseEntity<String> respuesta = null;
        if (usuarioService.guardar(u)!= null){
            respuesta= ResponseEntity.ok("El Usuario se cargo con exito");
        }else{
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el Usuario");
        }
        return respuesta;
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuarios> buscarId(@PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.buscarId(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        String resultado = "";
        ResponseEntity.ok(usuarioService.buscarId(id));
        usuarioService.eliminar(id);
        return resultado = "Se elimino correctamente";
    }
}
