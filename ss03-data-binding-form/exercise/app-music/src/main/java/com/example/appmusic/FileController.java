package com.example.appmusic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

@Controller
public class FileController {

    @GetMapping
    public ModelAndView showHome() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/save-file", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam CommonsMultipartFile file, HttpSession session) {
        String path = "D:\\CodeGym\\C0623G1_Pham_Van_Thanh_Module4\\ss03-data-binding-form\\exercise\\app-music\\src\\main\\webapp\\WEB-INF\\upload";
        String filename = file.getOriginalFilename();
        System.out.println(path + " " + filename);
        try {
            byte barr[] = file.getBytes();

            BufferedOutputStream bout = new BufferedOutputStream(
                    new FileOutputStream(path + "/" + filename));
            bout.write(barr);
            bout.flush();
            bout.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return new ModelAndView("view-file", "filename", path + "/" + filename);
    }


}
