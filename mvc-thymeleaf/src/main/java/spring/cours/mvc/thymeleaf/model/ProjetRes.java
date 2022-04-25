package spring.cours.mvc.thymeleaf.model;

import javax.persistence.Entity;

@Entity
public class ProjetRes extends Projet{
	
	private double budget;

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	

}
