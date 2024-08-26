package tech.chillo.imc;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "imc")
@Entity
public class Imc {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private double poids;
    private double taille;
    private double value;
    private String advice;
}
