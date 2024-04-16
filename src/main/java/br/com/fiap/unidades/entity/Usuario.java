package br.com.fiap.unidades.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "TB_USUARIO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_USUARIO_USERNAME", columnNames = "NM_USUARIO")
})
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NM_USUARIO")
    private String username;

    @Column(name = "DS_SENHA")
    private String password;

    @OneToOne
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_USUARIO_PESSOA"))
    private Pessoa pessoa;

}
