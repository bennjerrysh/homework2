package kr.co.jhta.springboot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "speaker_list")
public class Speaker {
    @Id
    private int id;
    
    private String name;
    private String party;

    @ManyToOne
    @JoinColumn(name ="press_id")
    private PressInfo pressInfo;
}
