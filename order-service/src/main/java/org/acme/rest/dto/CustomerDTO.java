package org.acme.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String nome;
    private String phone;
    private String email;
    private String address;
    private Long age;
    private String cpf;
}
