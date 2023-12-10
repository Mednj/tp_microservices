package com.naja.client2.entities;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="service-client")
public interface ClientService {
    @GetMapping(path="/client/{id}")
    public Client clientById(@PathVariable Long id);
}
