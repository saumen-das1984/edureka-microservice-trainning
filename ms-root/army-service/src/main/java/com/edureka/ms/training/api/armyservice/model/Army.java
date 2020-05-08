package com.edureka.ms.training.api.armyservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Army {
	@Id
	@GeneratedValue
	Long id;
	Long personId;
	int run;
	int wickets;
	int catches;
	int stumps;
}
