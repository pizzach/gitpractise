package com.report.reporter.controller;

import com.report.reporter.function.ExportDirectly;
import com.report.reporter.function.ProgrammingTheEngine;
import com.report.reporter.function.ReportFun;
import com.report.reporter.vo.HeroVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import javax.swing.JButton;

@RestController
@RequestMapping("/hero")
public class ReportController {

    @Autowired
    ReportFun reportFun;
    
    @Autowired
    ProgrammingTheEngine vaFun;
    

    @PostMapping("/query")
    public List<HeroVO> query(@RequestBody HeroVO vo){
    	
    	
    	System.out.println("ddd");
    	System.out.println("asd");
    	
    	
        return reportFun.queryHero(vo.getId());
    }
    
    
    

}
