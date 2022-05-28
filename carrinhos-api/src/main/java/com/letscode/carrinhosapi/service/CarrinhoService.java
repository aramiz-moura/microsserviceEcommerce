package com.letscode.carrinhosapi.service;


import com.letscode.carrinhosapi.domain.CarrinhoEntity;
import com.letscode.carrinhosapi.domain.CarrinhoRequest;
import com.letscode.carrinhosapi.domain.CarrinhoResponse;
import com.letscode.carrinhosapi.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }


    public CarrinhoEntity toEntity(CarrinhoRequest request){
        return new CarrinhoEntity(request.getIdUsuario());
    }


    public List<CarrinhoResponse> getCarrinhosAtivos(String usuarioId) {
        List<CarrinhoEntity> carrinhos = carrinhoRepository.getActiveCart(usuarioId,true);
        return carrinhos.stream().map(CarrinhoResponse::new).toList();
    }
}
