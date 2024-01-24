<<<<<<< HEAD
package gm.contactos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contacto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     Integer idContacto;
     String nombre;
     String celular;
     String email;

}
=======
package gm.contactos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contacto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
     Integer idContacto;
     String nombre;
     String celular;
     String email;

}
>>>>>>> a5d00601b59c4ef50c903a5a5f408a5e7a73ab8b
