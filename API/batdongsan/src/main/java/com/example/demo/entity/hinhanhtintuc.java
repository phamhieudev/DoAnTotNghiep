package com.example.demo.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hinhanhtintuc")
public class hinhanhtintuc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hinh")
	Long idHinh;

	@NotNull
	@Column(name = "url")
	String url;

	public Long getIdHinh() {
		return idHinh;
	}

	public void setIdHinh(Long idHinh) {
		this.idHinh = idHinh;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hinhanhtintuc")
	private Collection<Tintuc> tintucs;

}
