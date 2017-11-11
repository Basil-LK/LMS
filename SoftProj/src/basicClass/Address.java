package basicClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@Column(name="addressId")
	private int AddressId;
	@Column(name="streetname")
	private String streetname;
	@Column(name="houseNumber")
	private int houseNumber;
	@Column(name="city")
	private String city;
	@Column(name="visibility")
	private int visibility;
	

	public Address() {
		
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAddressId() {
		return AddressId;
	}
	public void setAddressId(int AddressId) {
		this.AddressId = AddressId;
	}
	public int isVisibility() {
		return visibility;
	}
	public void setVisibility(int i) {
		this.visibility = i;
	}

	


@Override
	public String toString() {
		return "Address [AddressId=" + AddressId + ", streetname=" + streetname + ", houseNumber=" + houseNumber
				+ ", city=" + city + ", visibility=" + visibility + "]";
	}
public void addressDAO() {
	
//opening session
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session session = sessionFactory.openSession();
session.beginTransaction();

Address address = new Address();
address = (Address) session.get(Address.class, 1);

//Update statement DAO ADDRESS

address.setVisibility(1);
session.update(address);


//closing session
session.getTransaction().commit();
System.out.println("Statement Worked!");
session.close();
sessionFactory.close();


}

public static void main(String[] args) {
	
	new Address().addressDAO();
}


}