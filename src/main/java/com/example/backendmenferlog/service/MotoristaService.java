package com.example.backendmenferlog.service;

import com.example.backendmenferlog.entities.Motorista;
import com.example.backendmenferlog.repositories.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public Motorista add(Motorista motorista) {
        return motoristaRepository.save(motorista);
    }

    public Motorista get(String cpf) {
        return motoristaRepository.findById(cpf).orElse(null);
    }

    public List<Motorista> getAll() {
        return motoristaRepository.findAll();
    }

    public boolean delete(String cpf) {
        Motorista motorista = motoristaRepository.findById(cpf).orElse(null);
        try {
            motoristaRepository.delete(motorista);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void update (String cpf, String name, String phone, String rg, LocalDate licenseExpiryDate, LocalDate birthDate, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep, String cnh, String cetpp,
                             MultipartFile arqCnh, MultipartFile comprovanteRs, MultipartFile arqCetpp, MultipartFile arqExamTox, MultipartFile arqAso) throws IOException {
        Motorista motorista = motoristaRepository.findById(cpf)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
        if (name != null)
            motorista.setName(name);

        if (phone != null)
            motorista.setPhone(phone);

        if (rg != null)
            motorista.setRg(rg);

        if (birthDate != null)
            motorista.setBirthDate(birthDate);

        if (cnh != null)
            motorista.setCnh(cnh);

        if (cetpp != null)
            motorista.setCetpp(cetpp);

        if (licenseExpiryDate != null)
            motorista.setLicenseExpiryDate(licenseExpiryDate);

        if (logradouro != null)
            motorista.setLogradouro(logradouro);

        if (numero != null)
            motorista.setNumero(numero);

        if (complemento != null)
            motorista.setComplemento(complemento);

        if (bairro != null)
            motorista.setBairro(bairro);

        if (cidade != null)
            motorista.setCidade(cidade);

        if (estado != null)
            motorista.setEstado(estado);

        if (cep != null)
            motorista.setCep(cep);

        if (arqCnh != null && !arqCnh.isEmpty())
            motorista.setArqCnh(arqCnh.getBytes());

        if (comprovanteRs != null && !comprovanteRs.isEmpty())
            motorista.setComprovanteRs(comprovanteRs.getBytes());

        if (arqCetpp != null && !arqCetpp.isEmpty())
            motorista.setArqCetpp(arqCetpp.getBytes());

        if (arqExamTox != null && !arqExamTox.isEmpty())
            motorista.setArqExamTox(arqExamTox.getBytes());

        if (arqAso != null && !arqAso.isEmpty())
            motorista.setArqAso(arqAso.getBytes());

        motoristaRepository.save(motorista);
    }
}
