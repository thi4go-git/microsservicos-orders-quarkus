package br.com.microsservico.rest.dto;

import br.com.microsservico.anottation.CPFunico;
import br.com.microsservico.anottation.EMAILunico;
import br.com.microsservico.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotBlank(message = "{campo.phone.obrigatorio}")
    private String phone;

    @NotBlank(message = "{campo.email.obrigatorio}")
    @Email(message = "{campo.email.invalido}")
    @EMAILunico
    private String email;

    @NotBlank(message = "{campo.address.obrigatorio}")
    private String address;

    @NotNull(message = "{campo.age.nullo}")
    private Long age;

    @NotBlank(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    @CPFunico
    private String cpf;

    public static CustomerDTO converterParaDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setAddress(customer.getAddress());
        dto.setAge(customer.getAge());
        dto.setEmail(customer.getEmail());
        dto.setNome(customer.getNome());
        dto.setPhone(customer.getPhone());
        dto.setCpf(customer.getCpf());
        return dto;
    }

}
