package br.com.fiap.unidades.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Table(name = "TB_CHEFE", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CHEFE_UNIDADE", columnNames = {"UNIDADE", "DT_FIM"}),
})
@Entity
public class Chefe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CHEFE")
    @SequenceGenerator(name = "SQ_CHEFE", sequenceName = "SQ_CHEFE", allocationSize = 1)
    @Column(name = "ID_CHEFE")
    private Long id;

    @Column(name = "ST_SUBSTITUTO")
    private Boolean substituto;

    @OneToOne
    @JoinColumn(
            name = "USUARIO",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(name = "FK_CHEFE_USUARIO"))
    private Usuario usuario;

    @OneToOne
    @JoinColumn(
            name = "UNIDADE",
            referencedColumnName = "ID_UNIDADE",
            foreignKey = @ForeignKey(name = "FK_CHEFE_UNIDADE"))
    private Unidade unidade;

    @Column(name = "DT_INICIO")
    private LocalDateTime inicio;

    @Column(name = "DT_FIM")
    private LocalDateTime fim;

}
