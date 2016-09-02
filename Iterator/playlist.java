
public class playlist{

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
