package fr.gestibank.entity.society;

/**
 * @author Jean-Francois
 *
 */
public class Address {
	
	private String _streetNumber;
	private String _street1;
	private String _street2;
	private String _city;
	private String _zipcode;
	private String _country;
	
	public String getStreetNumber() {
		return _streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		_streetNumber = streetNumber;
	}

	public String getStreet1() {
		return _street1;
	}
	public void setStreet1(String street1) {
		_street1 = street1;
	}
	public String getStreet2() {
		return _street2;
	}
	public void setStreet2(String street2) {
		_street2 = street2;
	}
	public String getCity() {
		return _city;
	}
	public void setCity(String city) {
		_city = city;
	}
	public String getZipcode() {
		return _zipcode;
	}
	public void setZipcode(String zipcode) {
		_zipcode = zipcode;
	}
	public String getCountry() {
		return _country;
	}
	public void setCountry(String country) {
		_country = country;
	}
	
	public Address(String streetNumber, String street1, String street2, String city, String zipcode, String country) {
		super();
		_streetNumber =streetNumber;
		_street1 = street1;
		_street2 = street2;
		_city = city;
		_zipcode = zipcode;
		_country = country;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_city == null) ? 0 : _city.hashCode());
		result = prime * result + ((_country == null) ? 0 : _country.hashCode());
		result = prime * result + ((_street1 == null) ? 0 : _street1.hashCode());
		result = prime * result + ((_street2 == null) ? 0 : _street2.hashCode());
		result = prime * result + ((_streetNumber == null) ? 0 : _streetNumber.hashCode());
		result = prime * result + ((_zipcode == null) ? 0 : _zipcode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (_city == null) {
			if (other._city != null)
				return false;
		} else if (!_city.equals(other._city))
			return false;
		if (_country == null) {
			if (other._country != null)
				return false;
		} else if (!_country.equals(other._country))
			return false;
		if (_street1 == null) {
			if (other._street1 != null)
				return false;
		} else if (!_street1.equals(other._street1))
			return false;
		if (_street2 == null) {
			if (other._street2 != null)
				return false;
		} else if (!_street2.equals(other._street2))
			return false;
		if (_streetNumber == null) {
			if (other._streetNumber != null)
				return false;
		} else if (!_streetNumber.equals(other._streetNumber))
			return false;
		if (_zipcode == null) {
			if (other._zipcode != null)
				return false;
		} else if (!_zipcode.equals(other._zipcode))
			return false;
		return true;
	}


}
