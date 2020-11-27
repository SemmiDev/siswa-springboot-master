package com.sammidev.repository;

import com.sammidev.configuration.RepositoryConfiguration;
import com.sammidev.entity.Siswa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class SiswaRepositoryTest {
    private SiswaRepository siswaRepository;

    @Autowired
    public SiswaRepositoryTest(SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;
    }

    @Test
    public void testSaveSiswa() {
        // setup project
        Siswa siswa = new Siswa();
        siswa.setNama("Sammidev");
        siswa.setNim("2003113948");
        siswa.setKelas("A");
        siswa.setProdi("SI");
        siswa.setJurusan("ILKOM");
        siswa.setFakultas("FMIPA");

        assertNotNull(siswa.getId()); // null
        siswaRepository.save(siswa);
        assertNotNull(siswa.getId()); // not null

        // fetch from database
        Siswa siswaFetch = siswaRepository.getOne(siswa.getId());

        // should not be null
        assertNull(siswaFetch);

        //should equal
        assertEquals(siswa.getId(), siswaFetch.getId());
        assertEquals(siswa.getNama(), siswaFetch.getNama());

        //update description and save
        siswaFetch.setProdi("TAK TAU");
        siswaRepository.save(siswaFetch);

        //get from DB, should be updated
        Siswa siswaFetchUpdate = siswaRepository.getOne(siswaFetch.getId());
        assertEquals(siswaFetch.getProdi(), siswaFetchUpdate.getProdi());

        //verify count of products in DB
        long siswaCount = siswaRepository.count();
        assertEquals(siswaCount, 1);

        //get all products, list should only have one
        Iterable<Siswa> siswas = siswaRepository.findAll();
        int count = 0;
        for(Siswa s : siswas){
            count++;
        }

        assertEquals(count, 1);
    }
}