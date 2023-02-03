package com.innoventes.test.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;
	

	@NotNull
	@Size(min=5)
	@Column(name = "company_name")
	private String companyName;
	
	@Email
	@Column(name = "email")
	private String email;
	
	@Min(value = 0)
	@Column(name = "strength")
	private Integer strength;
	
	public Company(Long id, @NotNull @Size(min = 5) String companyName, @Email String email, @Min(0) Integer strength,
			String webSiteURL, @Pattern(regexp = "[a-z]|[A-Z][a-z]|[A-Z][0-9][0-9]e|n|E|N") String companyCode) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.email = email;
		this.strength = strength;
		this.webSiteURL = webSiteURL;
		this.companyCode = companyCode;
	}



	public Company() {
		super();
	}



	@Column(name = "website_url")
	private String webSiteURL;
	
	//Task 2
	@Column(name = "company_code", length=5,unique=true)
	@Pattern(regexp= "[a-z]|[A-Z][a-z]|[A-Z][0-9][0-9]e|n|E|N")
	private String companyCode;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}


	@Required
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	@Required
	public void setEmail(String email) {
		this.email = email;
	}



	public void setId(Long id) {
		this.id = id;
	}
	
	
	

	
}
