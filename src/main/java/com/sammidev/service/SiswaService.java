package com.sammidev.service;
import com.sammidev.entity.Siswa;

import java.util.Optional;

public interface SiswaService {
    Iterable<Siswa> listAllSiswas();
    Siswa getSiswaById(Integer id);
    Siswa saveSiswa(Siswa siswa);
    void deleteSiswa(Integer id);
}
