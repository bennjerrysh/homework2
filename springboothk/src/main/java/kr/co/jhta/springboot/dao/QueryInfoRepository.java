package kr.co.jhta.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.jhta.springboot.dto.PressInfo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class QueryInfoRepository implements InfoRepository {

    private final EntityManager em;

    @Autowired
    public QueryInfoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<PressInfo> findAllByNameAndPartyAndDateBetween(Date from_date, Date to_date, String name, String party) {

        Query query = em.createNativeQuery("select p.id, p.date, p.time, p.title from (select * from press_info where date between :from_date and :to_date)as p, speaker_list as s where p.id = s.press_id and s.party like :party and s.name like :name order by p.date limit 100 ;", PressInfo.class);
        
        query.setParameter("name", name);
        query.setParameter("party", party);
        query.setParameter("from_date", from_date);
        query.setParameter("to_date", to_date);
        System.out.println(name);
        System.out.println(party);
        System.out.println(from_date);
        System.out.println(to_date);
        return query.getResultList();
    }
}
