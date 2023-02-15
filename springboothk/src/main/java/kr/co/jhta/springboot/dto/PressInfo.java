package kr.co.jhta.springboot.dto;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity(name = "press_info")
public class PressInfo {
    @Id
    private int id;
    private Date date;
    private LocalTime time;
    private String title;
}