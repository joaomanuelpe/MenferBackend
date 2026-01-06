package com.example.backendmenferlog.service;

import com.example.backendmenferlog.dto.ViagemDTO;
import com.example.backendmenferlog.dto.ViagemResponseDTO;
import com.example.backendmenferlog.entities.Motorista;
import com.example.backendmenferlog.entities.Viagem;
import com.example.backendmenferlog.repositories.MotoristaRepository;
import com.example.backendmenferlog.repositories.ViagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;
    @Autowired
    private MotoristaRepository motoristaRepository;

    @Transactional
    public List<ViagemResponseDTO> gravar(List<ViagemDTO> viagensDTO) {
        if (viagensDTO == null || viagensDTO.isEmpty()) {
            throw new RuntimeException("Nenhum dado fornecido");
        }

        List<ViagemResponseDTO> results = new ArrayList<>();

        for (ViagemDTO viagemDTO : viagensDTO) {
            if (viagemDTO.getEmpresa() == null || viagemDTO.getEmpresa().isEmpty()) {
                throw new RuntimeException("Empresa é obrigatória");
            }

            Viagem novaViagem = new Viagem(
                    null,
                    viagemDTO.getEmpresa(),
                    viagemDTO.getData(),
                    viagemDTO.getCte(),
                    viagemDTO.getPeso(),
                    viagemDTO.getNumContainer(),
                    viagemDTO.getTamContainer(),
                    viagemDTO.getTipoContainer(),
                    viagemDTO.getPlacaCavalo(),
                    viagemDTO.getPlacaReboque(),
                    viagemDTO.getMotorista(),
                    viagemDTO.getOrigem(),
                    viagemDTO.getDestino(),
                    viagemDTO.getEntrega(),
                    viagemDTO.getHoraDeChegada(),
                    viagemDTO.getHoraDeSaida(),
                    viagemDTO.getTipoDeOperacao(),
                    viagemDTO.getValePedagio(),
                    viagemDTO.getValorPedagio(),
                    viagemDTO.getAdiantamento(),
                    viagemDTO.getSaldo(),
                    viagemDTO.getAntecipacaoTerm(),
                    viagemDTO.getValorTerminal(),
                    viagemDTO.getEstadia(),
                    viagemDTO.getValorEstadia(),
                    viagemDTO.getNumeroFatur(),
                    viagemDTO.getDiaPgto(),
                    viagemDTO.getStatus()
            );

            Viagem viagemSalva = viagemRepository.save(novaViagem);
            results.add(new ViagemResponseDTO(viagemSalva));
        }

        return results;
    }

    @Transactional
    public ViagemResponseDTO atualizar(Long id, ViagemDTO viagemDTO) {
        Viagem viagemExistente = viagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viagem com ID " + id + " não encontrada"));
        if (viagemDTO.getEmpresa() != null) viagemExistente.setEmpresa(viagemDTO.getEmpresa());
        if (viagemDTO.getData() != null) viagemExistente.setData(viagemDTO.getData());
        if (viagemDTO.getCte() != null) viagemExistente.setCte(viagemDTO.getCte());
        if (viagemDTO.getPeso() != null) viagemExistente.setPeso(viagemDTO.getPeso());
        if (viagemDTO.getNumContainer() != null) viagemExistente.setNumContainer(viagemDTO.getNumContainer());
        if (viagemDTO.getTamContainer() != null) viagemExistente.setTamContainer(viagemDTO.getTamContainer());
        if (viagemDTO.getTipoContainer() != null) viagemExistente.setTipoContainer(viagemDTO.getTipoContainer());
        if (viagemDTO.getPlacaCavalo() != null) viagemExistente.setPlacaCavalo(viagemDTO.getPlacaCavalo());
        if (viagemDTO.getPlacaReboque() != null) viagemExistente.setPlacaReboque(viagemDTO.getPlacaReboque());
        if (viagemDTO.getMotorista() != null) viagemExistente.setMotorista(viagemDTO.getMotorista());
        if (viagemDTO.getOrigem() != null) viagemExistente.setOrigem(viagemDTO.getOrigem());
        if (viagemDTO.getDestino() != null) viagemExistente.setDestino(viagemDTO.getDestino());
        if (viagemDTO.getEntrega() != null) viagemExistente.setEntrega(viagemDTO.getEntrega());
        if (viagemDTO.getHoraDeChegada() != null) viagemExistente.setHoraDeChegada(viagemDTO.getHoraDeChegada());
        if (viagemDTO.getHoraDeSaida() != null) viagemExistente.setHoraDeSaida(viagemDTO.getHoraDeSaida());
        if (viagemDTO.getTipoDeOperacao() != null) viagemExistente.setTipoDeOperacao(viagemDTO.getTipoDeOperacao());
        if (viagemDTO.getValePedagio() != null) viagemExistente.setValePedagio(viagemDTO.getValePedagio());
        if (viagemDTO.getValorPedagio() != null) viagemExistente.setValorPedagio(viagemDTO.getValorPedagio());
        if (viagemDTO.getAdiantamento() != null) viagemExistente.setAdiantamento(viagemDTO.getAdiantamento());
        if (viagemDTO.getSaldo() != null) viagemExistente.setSaldo(viagemDTO.getSaldo());
        if (viagemDTO.getAntecipacaoTerm() != null) viagemExistente.setAntecipacaoTerm(viagemDTO.getAntecipacaoTerm());
        if (viagemDTO.getValorTerminal() != null) viagemExistente.setValorTerminal(viagemDTO.getValorTerminal());
        if (viagemDTO.getEstadia() != null) viagemExistente.setEstadia(viagemDTO.getEstadia());
        if (viagemDTO.getValorEstadia() != null) viagemExistente.setValorEstadia(viagemDTO.getValorEstadia());
        if (viagemDTO.getNumeroFatur() != null) viagemExistente.setNumeroFatur(viagemDTO.getNumeroFatur());
        if (viagemDTO.getDiaPgto() != null) viagemExistente.setDiaPgto(viagemDTO.getDiaPgto());
        if (viagemDTO.getStatus() != null) viagemExistente.setStatus(viagemDTO.getStatus());
        Viagem viagemAtualizada = viagemRepository.save(viagemExistente);

        return new ViagemResponseDTO(viagemAtualizada);
    }


    public List<ViagemResponseDTO> consultar(Long id) {
        if (id != null) {
            Viagem viagem = viagemRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));
            return List.of(new ViagemResponseDTO(viagem));
        }

        List<Viagem> viagens = viagemRepository.findAllByOrderByEmpresa();
        return viagens.stream()
                .map(ViagemResponseDTO::new)
                .collect(Collectors.toList());
    }

    public List<ViagemResponseDTO> consultarViagemDeUmMotorista(String nomeMotorista) {
        Motorista m = motoristaRepository.findByName(nomeMotorista);

        if (m == null) {
            throw new RuntimeException("Motorista não encontrado");
        }

        List<Viagem> viagens = viagemRepository.findByMotoristaOrderByEmpresa(m.getCpf());

        return viagens.stream()
                .map(ViagemResponseDTO::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public boolean excluir(Long idViagem) {
        if (idViagem != null) {
            Viagem viagem = viagemRepository.findById(idViagem).orElse(null);
            if (viagem == null) {
                return false;
            }
            viagemRepository.delete(viagem);
            return true;
        } else {
            viagemRepository.deleteAll();
            return true;
        }
    }
}
