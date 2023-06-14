package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.TemplateResponse;
import com.example.employee.model.templateInfo;

@RestController
@RequestMapping("api/v1/templates")
public class TemplateController {
	
	
//    private JdbcTemplate jdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

	@Autowired
    public TemplateController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public TemplateResponse getTemplates() {
    	List<templateInfo> templateList = jdbcTemplate.query("SELECT template_id, templatename FROM public.templatetype",
                (rs, rowNum) -> new templateInfo(rs.getInt("template_id"), rs.getString("templatename")));

        TemplateResponse response = new TemplateResponse();
        response.setResult(templateList);
        response.setHttpStatus("OK");
        response.setMessage("Success");
        response.setStatus(true);

        return response;
    }

}
