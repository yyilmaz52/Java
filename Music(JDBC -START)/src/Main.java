import java.beans.Statement;
import java.util.List;

import model.Album;
import model.Artist;
import model.DataSource;
import model.SongArtist;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataSource dataSource = new DataSource();
		if(!dataSource.open()) {
			System.out.println("Cant open datasource");
			return; 
		}
		List<Artist> artists = dataSource.queryArtists(dataSource.ORDER_BY_NONE);
		if(artists == null) {
			System.out.println("No artists!");
			return;
		}
		for(Artist artist : artists) {
			System.out.println("ID: " + artist.getId() + " Name: " + artist.getName());
		}
		
		
		List<String> albums = dataSource.queryAlbumsForArtist("Pink Floyd",dataSource.ORDER_BY_DESC);
		
		
		for(String album : albums) {
			System.out.println(album);
		}
		
		List<SongArtist> songArtists = dataSource.queryArtistsForSong("Go Your Own Way",DataSource.ORDER_BY_ASC);
		
		if(songArtists == null) {
			System.out.println("Couldnt find the artist for the song");
			return;
		}
		for(SongArtist artist : songArtists) {
			System.out.println("Artist name = " + artist.getArtistName() + " Album name : " +
					artist.getAlbumName() + " Track : " + artist.getTrack() );
		}
	
		dataSource.querySongsMetadata();
		
		int count = dataSource.getCount(DataSource.TABLE_SONGS);
		System.out.println("Number of songs "+count);
		
		dataSource.createViewForSongArtists();
		
		songArtists = dataSource.querySongInfoView("Go Your Own Way");
		if(songArtists.isEmpty()) {
			System.out.println("Couldnt find the artist for the song");
			return;
		}
		for(SongArtist artist : songArtists) {
			System.out.println("From VIEW - Artist name = " + artist.getArtistName() + " Album name : " +
					artist.getAlbumName() + " Track : " + artist.getTrack() );
		}
		
		dataSource.close();
	}

}
