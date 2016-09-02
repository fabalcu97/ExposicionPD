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
