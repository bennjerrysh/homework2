package kr.co.jhta.springboot.dao;



import java.util.Date;
import java.util.List;

import kr.co.jhta.springboot.dto.PressInfo;

public interface InfoRepository {
    

	List<PressInfo> findAllByNameAndPartyAndDateBetween(Date from_date, Date to_date, String name, String party);
}
