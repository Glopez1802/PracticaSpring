package com.guimarey.denunciaservice.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.util.Date; 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="denuncias")
@EntityListeners(AuditingEntityListener.class)
public class Denuncia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="dni", nullable=false, length=8)
	private String dni;
	@Column(name="fecha", nullable=false)
	private Date fecha;
	@Column(name="titulo", nullable = false, length = 30)
	private String titulo;
	@Column(name ="direccion", nullable = false, length = 200)
	private String direccion;
	@Column(name="descripcion", length = 255)
	private String descripcion;
}
