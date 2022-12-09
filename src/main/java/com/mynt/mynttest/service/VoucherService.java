package com.mynt.mynttest.service;

import com.mynt.mynttest.entity.Voucher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class VoucherService{

    @Value("${services.voucher}")
    private String voucherServiceUrl;

    public Optional<Voucher> retrieve(String key) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(voucherServiceUrl+key)
                .queryParam("key","apikey");
        ResponseEntity<Voucher>  response = restTemplate.getForEntity(
                builder.buildAndExpand().toUri(),
                Voucher.class);
        Voucher voucher = response.getBody();

        return Optional.ofNullable(voucher);
    }
}
