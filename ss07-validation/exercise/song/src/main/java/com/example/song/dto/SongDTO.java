package com.example.song.dto;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;

public class SongDTO {

    @Size(max = 800,message = "Không được vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,}$",message = "Chỉ được phép nhập chữ và số, không được phép nhập kí tự đặc biệt !")
    private String name;

    @Size(max = 300,message = "Không được vượt quá 300 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,}$",message = "Chỉ được phép nhập chữ và số, không được phép nhập kí tự đặc biệt !")
    private String singer;

    @Size(max = 1000,message = "Không được vượt quá 1000 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9\\,]{1,}$",message = "Không được phép nhập kí tự đặc biệt (Ngoại trừ dấu ',') !")
    private String typeMusic;

    public SongDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }
}
