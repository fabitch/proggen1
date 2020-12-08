public class Artist{
	String firstName;
	String lastName;
	MySuperDuperDateClass dateFirstPublished = new MySuperDuperDateClass(1,2,3);

	public Artist(String firstName, String lastName, MySuperDuperDateClass dateFirstPublished) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateFirstPublished = dateFirstPublished;
	}
}