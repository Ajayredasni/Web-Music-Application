package com.example.demo.entitiy;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class PlayListEntitiyCustomer {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	int id;
	String playListName;
	@ManyToMany
	List<SongsEntity> songsEntity;
	@ManyToOne
	UserEntity userEntity;
	public PlayListEntitiyCustomer() {
		super();
	}
	public PlayListEntitiyCustomer(int id, String playListName, List<SongsEntity> songsEntity, UserEntity userEntity) {
		super();
		this.id = id;
		this.playListName = playListName;
		this.songsEntity = songsEntity;
		this.userEntity = userEntity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlayListName() {
		return playListName;
	}
	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}
	public List<SongsEntity> getSongsEntity() {
		return songsEntity;
	}
	public void setSongsEntity(List<SongsEntity> songsEntity) {
		this.songsEntity = songsEntity;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	@Override
	public String toString() {
		return "PlayListEntitiyCustomer [id=" + id + ", playListName=" + playListName + ", songsEntity=" + songsEntity
				+ ", userEntity=" + userEntity + "]";
	}

}
