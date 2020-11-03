package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Province;
import cg.wbd.grandemonstration.repository.ProvinceRepository;
import cg.wbd.grandemonstration.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}
