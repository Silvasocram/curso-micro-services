package io.github.silvasocram.msclientes.application;

import io.github.silvasocram.msclientes.application.representation.ClienteSaveRequest;
import io.github.silvasocram.msclientes.application.services.ClienteService;
import io.github.silvasocram.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public String status(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest clienteSaveRequest){
        var cliente = clienteSaveRequest.toModel();
        clienteService.save(cliente);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                        .query("cpf={cpf}")
                                .buildAndExpand(cliente.getCpf())
                                        .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente (@RequestParam("cpf") String cpf){

        Optional<Cliente> cliente = clienteService.getByCPF(cpf);

        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }
}
