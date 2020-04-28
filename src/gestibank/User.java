package gestibank;

class User  {
	
	private String lastname;
	private String firstname;
	private int id;
	private String mail;
	private String password;
	private String gender;
	
	
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
		public boolean authentification(int id, String password) {
			return true;
		}

		@Override
		public String toString() {
			return "User [lastname=" + lastname + ", firstname=" + firstname + ", id=" + id + ", mail=" + mail
					+ ", password=" + password + ", gender=" + gender + "]";
		}

		
	


	
}
