package com.example.backendmenferlog.service;

import com.example.backendmenferlog.dto.AbastecimentoDTO;
import com.example.backendmenferlog.dto.AbastecimentoResponseDTO;
import com.example.backendmenferlog.dto.EstatisticasDTO;
import com.example.backendmenferlog.entities.Abastecimento;
import com.example.backendmenferlog.entities.Despesa;
import com.example.backendmenferlog.entities.Veiculo;
import com.example.backendmenferlog.repositories.AbastecimentoRepository;
import com.example.backendmenferlog.repositories.DespesaRepository;
import com.example.backendmenferlog.repositories.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbastecimentoService {
    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional
    public AbastecimentoResponseDTO save(AbastecimentoDTO abastecimentoDTO) {
        Optional<Veiculo> veiculoOpt = veiculoRepository.findById(abastecimentoDTO.getPlaca());
        if (veiculoOpt.isEmpty()) {
            throw new RuntimeException("Erro ao cadastrar abastecimento, placa informada não existe!");
        }

        Abastecimento novoAbastecimento = new Abastecimento(
                null,
                abastecimentoDTO.getData(),
                abastecimentoDTO.getPlaca(),
                abastecimentoDTO.getKmAnterior(),
                abastecimentoDTO.getKmPosterior(),
                abastecimentoDTO.getKmPercorrido(),
                abastecimentoDTO.getDieselLitros(),
                abastecimentoDTO.getMediaKmLitro(),
                abastecimentoDTO.getPrecoLitroDiesel(),
                abastecimentoDTO.getTotalDiesel(),
                abastecimentoDTO.getArlaLitros(),
                abastecimentoDTO.getPrecoLitroArla(),
                abastecimentoDTO.getTotalArla(),
                abastecimentoDTO.getTotal(),
                abastecimentoDTO.getObservacoes()
        );

        novoAbastecimento.calcularValores();
        abastecimentoRepository.save(novoAbastecimento);

        Despesa novaDespesa = new Despesa(
                null,
                abastecimentoDTO.getData(),
                abastecimentoDTO.getData(),
                novoAbastecimento.getTotal(),
                null,
                "Pendente",
                null,
                "Abastecimento - Placa " + abastecimentoDTO.getPlaca(),
                novoAbastecimento,
                null,
                null,
                null,
                null
        );

        despesaRepository.save(novaDespesa);

        abastecimentoRepository.save(novoAbastecimento);

        return new AbastecimentoResponseDTO(novoAbastecimento);
    }

    @Transactional
    public AbastecimentoResponseDTO update(AbastecimentoDTO abastecimentoDTO) {
        Abastecimento abastecimentoExistente = abastecimentoRepository.findById(abastecimentoDTO.getId())
                .orElseThrow(() -> new RuntimeException("Abastecimento não encontrado"));

        abastecimentoExistente.setData(abastecimentoDTO.getData());
        abastecimentoExistente.setPlaca(abastecimentoDTO.getPlaca());
        abastecimentoExistente.setKmAnterior(abastecimentoDTO.getKmAnterior());
        abastecimentoExistente.setKmPosterior(abastecimentoDTO.getKmPosterior());
        abastecimentoExistente.setKmPercorrido(abastecimentoDTO.getKmPercorrido());
        abastecimentoExistente.setDieselLitros(abastecimentoDTO.getDieselLitros());
        abastecimentoExistente.setMediaKmLitro(abastecimentoDTO.getMediaKmLitro());
        abastecimentoExistente.setPrecoLitroDiesel(abastecimentoDTO.getPrecoLitroDiesel());
        abastecimentoExistente.setTotalDiesel(abastecimentoDTO.getTotalDiesel());
        abastecimentoExistente.setArlaLitros(abastecimentoDTO.getArlaLitros());
        abastecimentoExistente.setPrecoLitroArla(abastecimentoDTO.getPrecoLitroArla());
        abastecimentoExistente.setTotalArla(abastecimentoDTO.getTotalArla());
        abastecimentoExistente.setTotal(abastecimentoDTO.getTotal());
        abastecimentoExistente.setObservacoes(abastecimentoDTO.getObservacoes());

        abastecimentoExistente.calcularValores();

        abastecimentoRepository.save(abastecimentoExistente);

        return new AbastecimentoResponseDTO(abastecimentoExistente);
    }

    public List<AbastecimentoResponseDTO> getAll() {
        List<Abastecimento> abastecimentos = abastecimentoRepository.findAllByOrderByDataDesc();

        return abastecimentos.stream().map(abastecimento -> {
            return new AbastecimentoResponseDTO(abastecimento);
        }).collect(Collectors.toList());
    }

    public AbastecimentoResponseDTO getById(Long id) {
        Abastecimento abastecimento = abastecimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Abastecimento não encontrado"));

        return new AbastecimentoResponseDTO(abastecimento);
    }

    public List<AbastecimentoResponseDTO> getByPlaca(String placa) {
        List<Abastecimento> abastecimentos = abastecimentoRepository.findByPlacaOrderByDataDesc(placa);

        return abastecimentos.stream().map(abastecimento -> {
            return new AbastecimentoResponseDTO(abastecimento);
        }).collect(Collectors.toList());
    }

    public List<AbastecimentoResponseDTO> getByPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        List<Abastecimento> abastecimentos = abastecimentoRepository.findByDataBetweenOrderByDataDesc(dataInicial, dataFinal);

        return abastecimentos.stream().map(abastecimento -> {
            return new AbastecimentoResponseDTO(abastecimento);
        }).collect(Collectors.toList());
    }

    public EstatisticasDTO getEstatisticas(String placa, LocalDate dataInicial, LocalDate dataFinal) {
        List<Abastecimento> abastecimentos = abastecimentoRepository.findForEstatisticas(placa, dataInicial, dataFinal);

        int totalAbastecimentos = abastecimentos.size();
        double totalDiesel = abastecimentos.stream()
                .mapToDouble(a -> a.getDieselLitros() != null ? a.getDieselLitros() : 0.0)
                .sum();
        double totalArla = abastecimentos.stream()
                .mapToDouble(a -> a.getArlaLitros() != null ? a.getArlaLitros() : 0.0)
                .sum();
        double totalGasto = abastecimentos.stream()
                .mapToDouble(a -> a.getTotal() != null ? a.getTotal() : 0.0)
                .sum();
        double mediaConsumo = abastecimentos.stream()
                .filter(a -> a.getMediaKmLitro() != null && a.getMediaKmLitro() > 0)
                .mapToDouble(Abastecimento::getMediaKmLitro)
                .average()
                .orElse(0.0);
        double totalKm = abastecimentos.stream()
                .mapToDouble(a -> a.getKmPercorrido() != null ? a.getKmPercorrido() : 0.0)
                .sum();

        return new EstatisticasDTO(totalAbastecimentos, totalDiesel, totalArla, totalGasto, mediaConsumo, totalKm);
    }

    @Transactional
    public boolean delete(Long id) {
        Abastecimento abastecimento = abastecimentoRepository.findById(id)
                .orElse(null);

        if (abastecimento == null) {
            return false;
        }
        Despesa despesa = despesaRepository.findByAbastecimentoId(abastecimento.getIdAbastecimento());
        if(despesa == null) {
            return false;
        }
        despesaRepository.delete(despesa);
        abastecimentoRepository.delete(abastecimento);

        return true;
    }
}
