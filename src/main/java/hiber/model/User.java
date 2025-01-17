package hiber.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id", unique = true)
   private Car usersCar;

   public User() {}
   
   public User(String firstName, String lastName, String email, Car usersCar) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.usersCar = usersCar;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

    public Car getUsersCar() {
        return usersCar;
    }

    public void setUsersCar(Car usersCar) {
        this.usersCar = usersCar;
    }

   @Override
   public String toString() {
      return "User{" +
              "usersCar=" + usersCar +
              ", email='" + email + '\'' +
              ", lastName='" + lastName + '\'' +
              ", firstName='" + firstName + '\'' +
              '}';
   }
}