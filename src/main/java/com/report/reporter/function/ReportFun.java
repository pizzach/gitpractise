package com.report.reporter.function;

import com.report.reporter.dao.ReportDao;
import com.report.reporter.vo.HeroVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ReportFun {

    @Autowired
    ReportDao reportDao;

    public List<HeroVO> queryHero(Integer id){
        List<HeroVO> list = new ArrayList<>();
        list = reportDao.queryHeroById(id);
        return list;
    }




}
