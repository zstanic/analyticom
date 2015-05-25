package de.analyticom.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playerregistrations", catalog = "analyticomdb")
public class PlayerRegistration extends BaseEntity<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 399989869884273836L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long prId;
	
	private Date dateFrom;
	
	private Date dateTo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "club_id")
	private Club club;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "player_id")
	private Player player;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return prId;
	}
	
	public void setPrId(Long prId) {
		this.prId = prId;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	

}
