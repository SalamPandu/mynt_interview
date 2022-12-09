package com.mynt.mynttest.controller;

import com.mynt.mynttest.dto.ParcelResponse;
import com.mynt.mynttest.service.ParcelService;
import com.mynt.mynttest.service.RuleService;
import com.mynt.mynttest.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mynt.mynttest.dto.ParcelRequest;
import com.mynt.mynttest.entity.Parcel;

import javax.validation.Valid;

@RequestMapping("/parcels")
@RestController
public class ParcelController {

    private final ParcelService parcelService;
    private final RuleService ruleService;
    private final VoucherService voucherService;

    @Autowired
    public ParcelController(ParcelService service, RuleService ruleService, VoucherService voucherService) {
        this.parcelService = service;
        this.ruleService = ruleService;
        this.voucherService = voucherService;
    }


    @PostMapping
    public ResponseEntity<?> addParcel(@Valid @NonNull @RequestBody ParcelRequest request) {
        Parcel parcel = parcelService.create(Parcel.builder()
                .weight(request.getWeight())
                .length(request.getLength())
                .width(request.getWidth())
                .height(request.getHeight())
                .voucherCode(request.getVoucherCode())
                .build());

        ParcelResponse data = new ParcelResponse(parcel);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

}
