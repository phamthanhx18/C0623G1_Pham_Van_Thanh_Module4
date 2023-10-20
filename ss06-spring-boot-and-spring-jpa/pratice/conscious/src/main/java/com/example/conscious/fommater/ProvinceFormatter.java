package com.example.conscious.fommater;

import com.example.conscious.model.Province;
import com.example.conscious.service.IProvinceService;
import org.hibernate.engine.jdbc.internal.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter {

    private final IProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    public Province parse(String text, Locale locale) {
        Optional<Province> provinceOptional = provinceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }

    @Override
    public String format(String source) {
        return null;
    }
}