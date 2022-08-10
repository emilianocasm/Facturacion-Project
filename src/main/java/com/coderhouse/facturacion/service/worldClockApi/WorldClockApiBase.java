package com.coderhouse.facturacion.service.worldClockApi;

import org.springframework.web.client.RestTemplate;

abstract class WorldClockApiBase {
    protected RestTemplate restTemplate = new RestTemplate();
    protected String url = "http://worldclockapi.com/api/json/utc/now";
}
