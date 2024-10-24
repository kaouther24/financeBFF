package com.bank.bff.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private final ServiceConfig serviceConfig;
    private final RestTemplate restTemplate;

    public CustomerService(ServiceConfig serviceConfig, RestTemplate restTemplate) {
        this.serviceConfig = serviceConfig;
        this.restTemplate = restTemplate;
    }

    public String getCustomerByUuid(String uuid) {
        String url = serviceConfig.getCustomersUrl() + "/byId/" + uuid;
        System.out.println("Customer URL: " + url);
        return restTemplate.getForObject(url, String.class);
    }
    public String getCustomerByName(String name, String surname) {
        String url = serviceConfig.getCustomersUrl() + "/byNameAndSurname/" + name + "/" + surname;
        return restTemplate.getForObject(url, String.class);
    }

}
