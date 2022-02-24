package com.report.reporter.dao;

import com.report.reporter.vo.HeroVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportDao {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<HeroVO> queryHeroById (Integer id){
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("select h.id, h.fate_contact_id, h.royal, h.star, h.status, h.name, h.nation, h.hero_level, h.cavalry_adapt, h.shield_adapt, h.archer_adapt, h.spearman_adapt, ");
        sBuilder.append("h.instrument_adapt, h.base_force, h.growth_force, h.base_intelligence, h.growth_intelligence, h.base_domination, h.growth_domination, base_speed, h.growth_speed, ");
        sBuilder.append("h.skill_main_id, h.skill_2nd_id, h.skill_3nd_id ");
        sBuilder.append("from hero h where h.id = :id ");

        return namedParameterJdbcTemplate.query(sBuilder.toString(),parameters,new BeanPropertyRowMapper<>(HeroVO.class));

    }

}
