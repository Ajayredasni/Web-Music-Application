package com.example.demo.entitiy;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class SongsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String songName;
	String songArtist;
	String songGenre;
	String songLink;
	@ManyToMany
	List<PlayListEntity> playListEntity;
	@ManyToMany
	List<PlayListEntitiyCustomer> playListEntityCustomer;

	public SongsEntity() {
		super();
	}

	public SongsEntity(int id, String songName, String songArtist, String songGenre, String songLink,
			List<PlayListEntity> playListEntity, List<PlayListEntitiyCustomer> playListEntityCustomer) {
		super();
		this.id = id;
		this.songName = songName;
		this.songArtist = songArtist;
		this.songGenre = songGenre;
		this.songLink = songLink;
		this.playListEntity = playListEntity;
		this.playListEntityCustomer = playListEntityCustomer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongArtist() {
		return songArtist;
	}

	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}

	public String getSongGenre() {
		return songGenre;
	}

	public void setSongGenre(String songGenre) {
		this.songGenre = songGenre;
	}

	public String getSongLink() {
		return songLink;
	}

	public void setSongLink(String songLink) {
		this.songLink = songLink;
	}

	public List<PlayListEntity> getPlayListEntity() {
		return playListEntity;
	}

	public void setPlayListEntity(List<PlayListEntity> playListEntity) {
		this.playListEntity = playListEntity;
	}

	public List<PlayListEntitiyCustomer> getPlayListEntityCustomer() {
		return playListEntityCustomer;
	}

	public void setPlayListEntityCustomer(List<PlayListEntitiyCustomer> playListEntityCustomer) {
		this.playListEntityCustomer = playListEntityCustomer;
	}

	@Override
	public String toString() {
		return "SongsEntity [id=" + id + ", songName=" + songName + ", songArtist=" + songArtist + ", songGenre="
				+ songGenre + ", songLink=" + songLink;
//		+ ", playListEntity=" + playListEntity
//				+ ", playListEntityCustomer=" + playListEntityCustomer + "]";
	}
	
}
