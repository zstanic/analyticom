package de.analyticom.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "countries", catalog = "analyticomdb")
public class Country extends BaseEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2054440920843533657L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long countryId;
	
	private String intCode;
	
	private String name;
	
	@OneToMany(mappedBy = "country")
	private List<Player> players = new ArrayList<Player>();

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return countryId;
	}

	public String getIntCode() {
		return intCode;
	}

	public void setIntCode(String intCode) {
		this.intCode = intCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}
