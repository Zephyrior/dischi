package it.epicode.dischi.cantanti;

import it.epicode.dischi.common.CommonResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CantanteService {

    @Autowired
    private CantanteRepository cantanteRepository;

    public Optional<Cantante> findByIdOptional(Long id) {
        Optional<Cantante> cantante = cantanteRepository.findById(id);

        if (!cantante.isPresent()){
            throw new EntityNotFoundException("Cannot find cantante with id: " + id);
        }
        return cantante;
    }

//    public Cantante findByIdOptional(Long id) {
//        Optional<Cantante> cantante = cantanteRepository.findById(id);
//
//        if (!cantante.isPresent()){
//            throw new EntityNotFoundException("Cannot find cantante with id: " + id);
//        }
//        return cantante.get();
//
//    funziona uguale al metodo sopra
//    }

    public CantanteResponse findById(Long id) {
        Cantante cantante = cantanteRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Cannot find cantante with id: " + id));

//        CantanteResponse response = new CantanteResponse();
//        BeanUtils.copyProperties(cantante, response);

        return fromEntity(cantante);
        //questa è la semplificazione delle due righe sopra
    }



    public List<CantanteResponse> findAll() {
        return cantanteRepository
//                .findAll()
//                .stream()
//                .map(cantante -> {
//                    CantanteResponse response = new CantanteResponse();
//                    BeanUtils.copyProperties(cantante, response);
//                    return response;
//                })
//                .toList();
                .findAll()
                .stream()
                .map(this::fromEntity)
                .toList();
        //questa è la semplificazione delle  righe sopra sfruttando il metodo sotto

    }

    public Page<Cantante> findAllComplete(Pageable pageable) {
        return cantanteRepository
                .findAll(pageable);
    }

    public CantanteResponse update(Long id, CantanteRequest request) {
        Cantante cantante = cantanteRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Cannot find cantante with id: " + id));
        BeanUtils.copyProperties(request, cantante);
        cantanteRepository.save(cantante);
        return fromEntity(cantante);
    }

    public CommonResponse create(CantanteRequest request) {
        Cantante cantante = new Cantante();
        BeanUtils.copyProperties(request, cantante);
        cantanteRepository.save(cantante);
        return new CommonResponse(cantante.getId());
    }

    public void delete(Long id) {
        Cantante cantante = cantanteRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Cannot find cantante with id: " + id));
        cantanteRepository.delete(cantante);
    }

    public CantanteResponse fromEntity(Cantante cantante) {
        CantanteResponse response = new CantanteResponse();
        BeanUtils.copyProperties(cantante, response);
        return response;
    }
}
