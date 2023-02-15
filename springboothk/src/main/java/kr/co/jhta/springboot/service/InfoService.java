package kr.co.jhta.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.springboot.dao.InfoRepository;
import kr.co.jhta.springboot.dao.QueryInfoRepository;
import kr.co.jhta.springboot.dto.PressInfo;

import java.util.Date;
import java.util.List;

@Service
public class InfoService {
    
    private final InfoRepository repository;

    @Autowired
    public InfoService(QueryInfoRepository repository) {
        this.repository = repository;
    }

    public List<PressInfo> getList(Date from_date, Date to_date, String name, String party) {
        return this.repository.findAllByNameAndPartyAndDateBetween(from_date, to_date, name, party);
    }

}
