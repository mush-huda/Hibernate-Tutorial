package org.huda.dto;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	@ManyToMany
	@JoinTable(name = "user_vehicle", joinColumns = @JoinColumn(name="user_id"),
					inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
	private Collection<Vehicle> vehicleList;

	public UserDetails() {
		vehicleList = new ArrayList<Vehicle>();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(Vehicle vehicle) {
		this.vehicleList.add(vehicle);
	}

}
