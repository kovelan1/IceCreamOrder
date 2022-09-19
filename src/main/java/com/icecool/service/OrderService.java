package com.icecool.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icecool.exception.InvalidOrderException;
import com.icecool.exception.ResourceNotFoundException;
import com.icecool.model.Condiment;
import com.icecool.model.Flavor;
import com.icecool.model.Order;
import com.icecool.model.PriceData;

@Service
public class OrderService {
	
private final String ICECREAM_JSON = "/data/icecream.json";
	
	public double getTotalPrice( Order order) throws ResourceNotFoundException, InvalidOrderException {
		TypeReference<PriceData> typeReference = new TypeReference<PriceData>() {
		};
		
		double totalprice =0.00;
		
		InputStream inputStream = TypeReference.class.getResourceAsStream(ICECREAM_JSON);
		try {
			PriceData priceData = new ObjectMapper().readValue(inputStream, typeReference);
			
			if(verifyOrder(priceData, order)) {
				totalprice= getFlovorPrice(priceData, order.getFlavor())+ getCondimentsPrice(priceData,order.getCondiments())+ getCornPrice(priceData, order.getCone());
				
			}
			else {
				throw new InvalidOrderException("Condiment type not match");
			}
			
			
			
				
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return totalprice;
	}

	public double getFlovorPrice(PriceData priceData,String name) throws ResourceNotFoundException {
		
		return priceData.getFlavors().stream()
				.filter(f -> f.getName().equals(name)).findFirst()
				.orElseThrow(()-> new ResourceNotFoundException("Flavor", "name", name))
				.getPrice();
		
		
	}
	
	public double getCondimentsPrice(PriceData priceData,List<String> names) {
		
		return priceData.getCondiments().stream()
				.filter(f -> names.stream().anyMatch(n-> n.equals(f.getName())))
				.mapToDouble(Condiment::getPrice).sum();
				
	}
	
	
	public double getCornPrice(PriceData priceData,String name) throws ResourceNotFoundException {
		
		return priceData.getCones().stream()
				.filter(f -> f.getName().equals(name)).findFirst()
				.orElseThrow(()-> new ResourceNotFoundException("Corn", "name", name))
				.getPrice();
		
	}
	
	private boolean verifyOrder(PriceData priceData, Order order) {
		
		Flavor flavor= priceData.getFlavors().stream().filter(f-> f.getName().equals(order.getFlavor())).findFirst().get();
		
		return flavor.getAvailableCondiments().stream().anyMatch(c-> order.getCondiments().contains(c.getName()));
		
	}
	
}
