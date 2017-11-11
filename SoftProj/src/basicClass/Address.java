package basicClass;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="Address")
public class Address {
	
	@Id
	//@Column(name="addressId")
	private int AddressId;
	//@Column(name="streetname")
	private String streetname;
	//@Column(name="houseNumber)
	private int houseNumber;
	//@Column(name="city")
	private String city;
	//@Column(name="visibility")
	private int visibility;
	
	public Address(String streetname, int houseNumber, String city) {
		super();
		this.streetname = streetname;
		this.houseNumber = houseNumber;
		this.city = city;
	}
	public Address(int AddressId,String streetname, int houseNumber, String city) {
		super();
		this.AddressId = AddressId;
		this.streetname = streetname;
		this.houseNumber = houseNumber;
		this.city = city;
	}
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
	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
		
		/////////////////////////////////////////////////////
		///////////////////////DAO///////////////////////////
		/////////////////////////////////////////////////////
	
public static void main(String[] args) {
		
	
		
		
			
			
			
			
			//opening session
			
			SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Address.class).buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Address address = new Address();
			
			
			//Statement UPDATE
			address =(Address) session.get(Address.class, 0);
			//address.setStreetname("updated");
			//session.update(address);
			
			
			//closing session
			session.getTransaction().commit();
			System.out.println("Statement Worked!");
			session.close();
			sessionFactory.close();

		}
}
	
