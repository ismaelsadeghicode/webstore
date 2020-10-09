package com.mapsa.webstore.customer.repository;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(value = "location-service")
@RibbonClient
public interface LocationProxy {
}
