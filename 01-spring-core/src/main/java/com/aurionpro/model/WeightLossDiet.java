package com.aurionpro.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class WeightLossDiet implements IDiet {

	@Override
	public String getDietPlan() {
		// TODO Auto-generated method stub
		return "eat nothing to reduce weight";
	}

}
