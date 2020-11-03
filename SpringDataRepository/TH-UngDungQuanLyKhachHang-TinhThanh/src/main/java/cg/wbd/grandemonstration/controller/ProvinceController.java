package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Province;
import cg.wbd.grandemonstration.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/create-province")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/provinces/create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveCreate(@ModelAttribute("province")  Province province){
        provinceService.save(province);

        ModelAndView modelAndView = new ModelAndView("/provinces/create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/provinces")
    public ModelAndView listProvinces(){
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/provinces/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Province> province = provinceService.findById(id);
        if(province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/provinces/edit");
            modelAndView.addObject("province", province);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province){
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/provinces/edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Province> province = provinceService.findById(id);
        if(province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/provinces/delete");
            modelAndView.addObject("province", province);
            return modelAndView;

        }else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-province")
    public String deleteProvince(@ModelAttribute("province") Province province){
        provinceService.remove(province.getId());
        return "redirect:provinces";
    }
}
