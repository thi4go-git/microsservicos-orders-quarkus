package br.com.microsservico.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String phone;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String address;

    @Column
    private Long age;

    @Column(length = 11, unique = true, nullable = false)
    private String cpf;

    public Customer( String nome, String phone, String email, String address, Long age, String cpf) {
        this.nome = nome;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.age = age;
        this.cpf = cpf;
    }
}
