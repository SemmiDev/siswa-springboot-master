package com.sammidev.boostrap;

import com.sammidev.entity.Siswa;
import com.sammidev.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SiswaLoader implements ApplicationListener<ContextRefreshedEvent> {
    private SiswaRepository siswaRepository;

    @Autowired
    public SiswaLoader(SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Siswa siswa = new Siswa();
        siswa.setNama("Sammi Aldhi Yanto");
        siswa.setNim("2003113948");
        siswa.setKelas("A");
        siswa.setProdi("Sistem Informasi");
        siswa.setJurusan("ILKOM");
        siswa.setFakultas("FMIPA");
        siswaRepository.save(siswa);

        Siswa siswa2 = new Siswa();
        siswa2.setNama("Ayatullah Ramadhan Jacoeb");
        siswa2.setNim("2003113949");
        siswa2.setKelas("A");
        siswa2.setProdi("Sistem Informasi");
        siswa2.setJurusan("ILKOM");
        siswa2.setFakultas("FMIPA");
        siswaRepository.save(siswa2);

        Siswa siswa3 = new Siswa();
        siswa3.setNama("Aditya Andika Putra");
        siswa3.setNim("2003113938");
        siswa3.setKelas("C");
        siswa3.setProdi("Sistem Informasi");
        siswa3.setJurusan("ILKOM");
        siswa3.setFakultas("FMIPA");
        siswaRepository.save(siswa3);

        Siswa siswa4 = new Siswa();
        siswa4.setNama("Gusnur");
        siswa4.setNim("2003133948");
        siswa4.setKelas("D");
        siswa4.setProdi("Sistem Informasi");
        siswa4.setJurusan("ILKOM");
        siswa4.setFakultas("FMIPA");
        siswaRepository.save(siswa4);

        Siswa siswa5 = new Siswa();
        siswa5.setNama("Dandi Arnanda");
        siswa5.setNim("2003113918");
        siswa5.setKelas("B");
        siswa5.setProdi("Sistem Informasi");
        siswa5.setJurusan("ILKOM");
        siswa5.setFakultas("FMIPA");
        siswaRepository.save(siswa5);
    }
}
