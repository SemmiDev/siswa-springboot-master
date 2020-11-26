package com.sammidev.controller;

import com.sammidev.entity.Siswa;
import com.sammidev.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SiswaController {
    private SiswaService siswaService;

    @Autowired
    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @RequestMapping(value = "/siswas", method = RequestMethod.GET)
    public String listSiswa(Model model){
        model.addAttribute("siswas", siswaService.listAllSiswas());
        return "siswas";
    }


    @RequestMapping("siswa/{id}")
    public String showSiswa(@PathVariable Integer id, Model model){
        model.addAttribute("siswa", siswaService.getSiswaById(id));
        return "siswashow";
    }

    @RequestMapping("siswa/edit/{id}")
    public String editSiswa(@PathVariable Integer id, Model model){
        model.addAttribute("siswa", siswaService.getSiswaById(id));
        return "siswaform";
    }

    @RequestMapping("siswa/new")
    public String newSiswa(Model model){
        model.addAttribute("siswa", new Siswa());
        return "siswaform";
    }

    @RequestMapping(value = "siswa", method = RequestMethod.POST)
    public String saveSiswa(Siswa siswa){
        siswaService.saveSiswa(siswa);
        return "redirect:/siswa/" + siswa.getId();
    }

    @RequestMapping("siswa/delete/{id}")
    public String deleteSiswa(@PathVariable Integer id){
        siswaService.deleteSiswa(id);
        return "redirect:/siswas";
    }

}
