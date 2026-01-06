package com.example.backendmenferlog.service;

import com.example.backendmenferlog.dto.ComissaoMotoristaDTO;
import com.example.backendmenferlog.dto.ComissaoMotoristaResponseDTO;
import com.example.backendmenferlog.entities.ComissaoMotorista;
import com.example.backendmenferlog.repositories.ComissaoMotoristaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ComissaoMotoristaService {
    @Autowired
    private ComissaoMotoristaRepository comissaoMotoristaRepository;

    @Transactional
    public ComissaoMotoristaResponseDTO save(ComissaoMotoristaDTO comissaoMotoristaDTO) {
        if (comissaoMotoristaDTO.getIdDaViagem() == null) {
            throw new RuntimeException("ID da viagem é obrigatório!");
        }

        ComissaoMotorista novaComissao = new ComissaoMotorista(
                null,
                comissaoMotoristaDTO.getIdDaViagem(),
                comissaoMotoristaDTO.getVale(),
                comissaoMotoristaDTO.getComissao(),
                comissaoMotoristaDTO.getDescricao()
        );

        comissaoMotoristaRepository.save(novaComissao);

        return new ComissaoMotoristaResponseDTO(novaComissao);
    }

    @Transactional
    public List<ComissaoMotoristaResponseDTO> saveMultiple(List<ComissaoMotoristaDTO> comissoesDTO) {
        if (comissoesDTO == null || comissoesDTO.isEmpty()) {
            throw new RuntimeException("Nenhum dado fornecido");
        }

        return comissoesDTO.stream().map(comissaoDto -> {
            if (comissaoDto.getIdDaViagem() == null) {
                throw new RuntimeException("ID da viagem é obrigatório para uma das comissões");
            }

            ComissaoMotorista novaComissao = new ComissaoMotorista(
                    null,
                    comissaoDto.getIdDaViagem(),
                    comissaoDto.getVale(),
                    comissaoDto.getComissao(),
                    comissaoDto.getDescricao()
            );

            comissaoMotoristaRepository.save(novaComissao);
            return new ComissaoMotoristaResponseDTO(novaComissao);
        }).collect(Collectors.toList());
    }

    @Transactional
    public ComissaoMotoristaResponseDTO update(ComissaoMotoristaDTO comissaoMotoristaDTO) {
        ComissaoMotorista comissaoExistente = comissaoMotoristaRepository.findById(comissaoMotoristaDTO.getIdComissao())
                .orElseThrow(() -> new RuntimeException("Comissão não encontrada"));

        if (comissaoMotoristaDTO.getIdDaViagem() == null) {
            throw new RuntimeException("ID da viagem é obrigatório!");
        }

        comissaoExistente.setIdDaViagem(comissaoMotoristaDTO.getIdDaViagem());
        comissaoExistente.setVale(comissaoMotoristaDTO.getVale());
        comissaoExistente.setComissao(comissaoMotoristaDTO.getComissao());
        comissaoExistente.setDescricao(comissaoMotoristaDTO.getDescricao());

        comissaoMotoristaRepository.save(comissaoExistente);

        return new ComissaoMotoristaResponseDTO(comissaoExistente);
    }

    public List<ComissaoMotoristaResponseDTO> getAll() {
        List<ComissaoMotorista> comissoes = comissaoMotoristaRepository.findAllByOrderByIdComissaoDesc();

        return comissoes.stream().map(comissao -> {
            return new ComissaoMotoristaResponseDTO(comissao);
        }).collect(Collectors.toList());
    }

    public ComissaoMotoristaResponseDTO getById(Long id) {
        ComissaoMotorista comissao = comissaoMotoristaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comissão não encontrada"));

        return new ComissaoMotoristaResponseDTO(comissao);
    }

    public List<ComissaoMotoristaResponseDTO> getByViagem(Long idDaViagem) {
        List<ComissaoMotorista> comissoes = comissaoMotoristaRepository.findByIdDaViagemOrderByIdComissaoDesc(idDaViagem);

        return comissoes.stream().map(comissao -> {
            return new ComissaoMotoristaResponseDTO(comissao);
        }).collect(Collectors.toList());
    }

    public List<ComissaoMotoristaResponseDTO> getByMotorista(String motorista) {
        List<ComissaoMotorista> comissoes = comissaoMotoristaRepository.findByMotoristaOrderByIdComissaoDesc(motorista);

        return comissoes.stream().map(comissao -> {
            return new ComissaoMotoristaResponseDTO(comissao);
        }).collect(Collectors.toList());
    }

    public Map<String, Object> getEstatisticas(Long idDaViagem, String motorista) {
        List<ComissaoMotorista> comissoes = comissaoMotoristaRepository.findForEstatisticas(idDaViagem, motorista);

        int totalComissoes = comissoes.size();
        double totalValorComissao = comissoes.stream()
                .mapToDouble(c -> c.getComissao() != null ? c.getComissao() : 0.0)
                .sum();
        double totalVale = comissoes.stream()
                .mapToDouble(c -> c.getVale() != null ? c.getVale() : 0.0)
                .sum();
        double mediaComissao = totalComissoes > 0 ? totalValorComissao / totalComissoes : 0.0;

        Map<String, Object> estatisticas = new HashMap<>();
        estatisticas.put("totalComissoes", totalComissoes);
        estatisticas.put("totalValorComissao", totalValorComissao);
        estatisticas.put("totalVale", totalVale);
        estatisticas.put("mediaComissao", mediaComissao);
        estatisticas.put("comissoes", comissoes.stream()
                .map(ComissaoMotoristaResponseDTO::new)
                .collect(Collectors.toList()));

        return estatisticas;
    }

    @Transactional
    public boolean delete(Long id) {
        ComissaoMotorista comissao = comissaoMotoristaRepository.findById(id)
                .orElse(null);

        if (comissao == null) {
            return false;
        }

        comissaoMotoristaRepository.delete(comissao);
        return true;
    }
}