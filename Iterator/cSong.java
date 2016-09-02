public class cSong{
	String mName;
	String mAuthor;
	String mAlbum;

	public cSong(String author, String name, String album){
		mName = name;
		mAuthor = author;
		mAlbum = album;
	}

	public void print(){
		System.out.println("-----------------------------");
		System.out.println("Song's Name: " + mName);
		System.out.println("Song's Author: " + mAuthor);
		System.out.println("Song's Album: " + mAlbum);
		System.out.println("-----------------------------");
	}

}
