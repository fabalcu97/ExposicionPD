interface Iterator{
	public boolean isDone();
	public boolean hasNext();
	public void next();
	public cSong first();
	public cSong current();
}

class cSong{
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

class playlist{

	String mName;
	public cSong mList[];
	int mListIndex = 0;

	public playlist(String name, int size){
		mName = name;
		mList = new cSong[size];
	}

	public void add(String author, String name, String album){
		cSong song = new cSong(author, name, album);
		mList[mListIndex++] = song;
	}

	public Iterator getIterator(){
		return new PlaylistIterator();
	}

	public class PlaylistIterator implements Iterator{

		int mIndex = 0;

		@Override
		public cSong first(){
			if ( mList.length != 0 ) {
				return mList[0];
			}
			return null;
		}

		@Override
		public cSong current(){
			if ( mList.length != 0 ) {
				return mList[mIndex];
			}
			return null;
		}

		@Override
		public boolean isDone(){
			if( mIndex >= mList.length ){
				return true;
			}
			return false;
		}

		@Override
		public boolean hasNext(){
			if( mIndex < mList.length ){
				return true;
			}
			return false;
		}

		@Override
		public void next(){
			if( this.hasNext() ){
				mIndex++;
			}
		}

	}
}

public class IteratorDemo{

	public static void main(String[] args){

		playlist lista = new playlist("Rock", 2);

		lista.add("Queen", "Bohemian Rapsody", "A Night at the Opera");
		lista.add("Guns N' Roses", "Estranged", "Use Your Illusion II");

		for( Iterator iter = lista.getIterator(); iter.hasNext(); iter.next()){
			iter.current().print();
		}

	}

}
