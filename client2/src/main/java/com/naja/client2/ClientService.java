package com.naja.client2;


import com.naja.client2.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="service-client")
public interface ClientService {
    @GetMapping(path="/clients/{id}")
    public Client clientById(@PathVariable Long id);
}
