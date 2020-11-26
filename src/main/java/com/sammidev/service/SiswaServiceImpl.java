package com.sammidev.service;

import com.sammidev.entity.Siswa;
import com.sammidev.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SiswaServiceImpl implements SiswaService {
    private SiswaRepository siswaRepository;

    @Autowired
    public SiswaServiceImpl(SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;
    }

    @Override
    public Iterable<Siswa> listAllSiswas() {
        return siswaRepository.findAll();
    }

    @Override
    public Siswa getSiswaById(Integer id) {
        return siswaRepository.getOne(id);
    }

    @Override
    public Siswa saveSiswa(Siswa siswa) {
        return siswaRepository.save(siswa);
    }

    @Override
    public void deleteSiswa(Integer id) {
        siswaRepository.deleteById(id);
    }
}