package br.edu.unisep.tads.ifud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "senha", nullable = false, length = 50)
    private String senha;

    @Column(name = "created_at", nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "created_date", nullable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault("current_timestamp")
    private Date createdDate;

    @Column(name = "updated_by", nullable = false)
    @LastModifiedBy
    private String updatedBy;
    
    @Column(name = "updated_date", nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @ColumnDefault("current_timestamp")
    private Date updatedDate;

}
