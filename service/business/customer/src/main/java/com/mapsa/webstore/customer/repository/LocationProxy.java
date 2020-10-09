package com.mapsa.webstore.customer.repository;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "location-service")
@RibbonClient
public interface LocationProxy {
}
