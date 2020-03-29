package org.huda.dto;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="skills")
public class Skill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="skill_id")
	private int skillId;
	
	@Column(name="skill_name")
	private String skillName;
	
	@ManyToMany(mappedBy="skills")
	private List<Employee> employees;
	
	public Skill() {
		this.employees = new ArrayList<Employee>();
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees.add(employees);
	}

}
