package de.analyticom.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "players", catalog = "analyticomdb")
public class Player extends BaseEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4739872685634993102L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long playerId;
	
	private Date dateOfBirth;
	
	private String firstName;
	
	private String lastName;
	
	private String placeOfBirth;
	
	private String uniqueID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id")
	private Country country;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "player")
	private List<PlayerRegistration> plyRegs = new ArrayList<PlayerRegistration>();

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return playerId;
	}
	
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public List<PlayerRegistration> getPlyRegs() {
		return plyRegs;
	}
	
	public void setPlyRegs(List<PlayerRegistration> plyRegs) {
		this.plyRegs = plyRegs;
	}

}
