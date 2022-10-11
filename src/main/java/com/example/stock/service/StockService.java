package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository){
        this.stockRepository=stockRepository;
    }
    //트랜잭션 어노테이션을 이용하게 되면 스프링 트랜잭션의 동작방식으로 인해 동시성 문제가 해결되지 않는다.
    public synchronized void decrease(Long id, Long quantity){
        Stock stock=stockRepository.findById(id).orElseThrow();

        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);

    }

}
