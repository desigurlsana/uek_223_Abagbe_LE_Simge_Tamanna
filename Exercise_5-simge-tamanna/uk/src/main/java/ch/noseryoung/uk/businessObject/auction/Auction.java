package ch.noseryoung.uk.businessObject.auction;

import javax.persistence.*;

// This is an example class on a domain model could be built
// These annotations show hibernate that this is an entity
@Entity

// This annotation defines this entity as it's own table with it's given name
// We can also not define it's name, but then it'd take the name of the class itself and that wouldn't be best practice
@Table(name = "auction")
public class Auction {

    // Regular attributes
    // The primary key, this annotation defines that this is a primary key:
    @Id

    // This annotation makes sure that our id gets auto-incremented
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // This annotation simply defines that this attribute has it's own column and how that column is called
    @Column(name = "id")
    private int id;

    // In this example the name has not been defined, if you do this hibernate will plainly use the name of the variable itself
    // The nullable parameter defines if this attribute can be null in the database
    @Column(nullable = false)
    private String name;

    // Standard empty constructor
    public Auction() {
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
