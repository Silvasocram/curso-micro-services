package io.github.silvasocram.mscartoes.application.service;

import io.github.silvasocram.mscartoes.domain.ClienteCartao;
import io.github.silvasocram.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
    private final ClienteCartaoRepository clienteCartaoRepository;

    public List<ClienteCartao> listClienteCartaoByCpf(String cpf){
        return clienteCartaoRepository.findByCpf(cpf);
    }
}
