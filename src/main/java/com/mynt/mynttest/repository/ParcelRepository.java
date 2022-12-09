package com.mynt.mynttest.repository;


import com.mynt.mynttest.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}

