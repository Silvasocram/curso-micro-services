package io.github.silvasocram.msclientes.application.services;

import io.github.silvasocram.msclientes.domain.Cliente;
import io.github.silvasocram.msclientes.infra.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente save (Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf){
        return clienteRepository.findByCpf(cpf);
    }

}
