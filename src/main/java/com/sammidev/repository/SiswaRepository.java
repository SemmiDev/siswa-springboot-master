package com.sammidev.repository;

import com.sammidev.entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SiswaRepository extends JpaRepository<Siswa, Integer> {
}