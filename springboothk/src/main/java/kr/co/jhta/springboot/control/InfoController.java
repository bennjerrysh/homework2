package kr.co.jhta.springboot.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.springboot.dto.PressInfo;
import kr.co.jhta.springboot.service.InfoService;

import java.util.Date;
import java.util.List;

@Controller
public class InfoController {

    @Autowired
    private InfoService service;

    @GetMapping("list")
    public String List(
        @RequestParam(value ="from_date", defaultValue = "1970-01-01")@DateTimeFormat(pattern = "yyyy-MM-dd") Date from_date, 
        @RequestParam(value ="to_date", defaultValue = "2099-12-31") @DateTimeFormat(pattern = "yyyy-MM-dd") Date to_date, 
        @RequestParam(value ="name", defaultValue = "%") String name, 
        @RequestParam(value ="party", defaultValue = "%") String party,
        Model model) 
    {
        List<PressInfo> InfoList = this.service.getList(from_date, to_date, name, party );
        model.addAttribute("InfoList", InfoList);
        System.out.println(InfoList);
        return "list";
    }
}