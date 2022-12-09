package com.mynt.mynttest.controller;

import com.mynt.mynttest.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/vouchers")
@RestController
public class VoucherController {

    private final VoucherService service;
    @Autowired
    public VoucherController(VoucherService service){
        this.service = service;
    }
    @GetMapping(path="/sample/{code}")
    public ResponseEntity<?> getVoucher(@PathVariable("code") String code) {
        Optional<?> voucher = service.retrieve(code);
        return new ResponseEntity<>(voucher, HttpStatus.OK);
    }
}
