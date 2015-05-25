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
@Table(name = "clubs", catalog = "analyticomdb")
public class Club extends BaseEntity<Long> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2934785906363561017L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long clubId;
	
	private String name;
	
	private String type;
	
	@OneToMany(mappedBy = "club")
	private List<PlayerRegistration> plyRegs = new ArrayList<PlayerRegistration>();

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return clubId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<PlayerRegistration> getPlyRegs() {
		return plyRegs;
	}
	
	public void setPlyRegs(List<PlayerRegistration> plyRegs) {
		this.plyRegs = plyRegs;
	}
}
