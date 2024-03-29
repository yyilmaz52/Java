package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

		public static final String DB_NAME = "music.db";
		public static final String CONNECTION_STRING ="jdbc:sqlite:D:\\java\\projeler\\Music\\"+ DB_NAME;
		
		
		public static final String TABLE_ALBUMS = "albums";
		public static final String COLUMN_ALBUM_ID = "_id";
		public static final String COLUMN_ALBUM_NAME = "name";
		public static final String COLUMN_ALBUM_ARTIST = "artist";
		
		public static final int INDEX_ALBUM_ID =1;
		public static final int INDEX_ALBUM_NAME = 2;
		public static final int INDEX_ALBUM_ARTIST =3;
		
		public static final String TABLE_ARTIST = "artists";
		public static final String COLUMN_ARTIST_ID = "_id";
		public static final String COLUMN_ARTIST_NAME = "name";
		
		public static final int INDEX_ARTIST_ID = 1;
		public static final int INDEX_ARTIST_NAME = 2;
		
		public static final String TABLE_SONGS = "songs";
		public static final String COLUMN_SONG_ID = "_id";
		public static final String COLUMN_SONG_TRACK = "track";
		public static final String COLUMN_SONG_TITLE = "title";
		public static final String COLUMN_SONG_ALBUM = "album";
		
		public static final int INDEX_SONG_ID = 1;
		public static final int INDEX_SONG_TRACK = 2;
		public static final int INDEX_SONG_TITLE = 3;
		public static final int INDEX_SONG_ALBUM = 4;
		
		public static final int ORDER_BY_NONE = 1;
		public static final int ORDER_BY_ASC = 2;
		public static final int ORDER_BY_DESC = 3;
		
		public static final String QUERY_ALBUMS_BY_ARTIST_START = "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +" FROM " + TABLE_ALBUMS
		+ " INNER JOIN " + TABLE_ARTIST	+ " ON " + TABLE_ALBUMS
		+ "." + COLUMN_ALBUM_ARTIST	+ " = "	+ TABLE_ARTIST
		+ "." + COLUMN_ARTIST_ID +" WHERE " + TABLE_ARTIST + "."+COLUMN_ARTIST_NAME	+" =  \"";
		
		public static final String QUERY_ALBUMS_BY_ARTIST_SORT = 
				" ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";
		
		public static final String QUERY_ARTIST_FOR_SONG_START = 
				"SELECT " + TABLE_ARTIST + "." + COLUMN_ARTIST_NAME +  ", " +
				TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
				TABLE_SONGS + "." + COLUMN_SONG_TRACK + " FROM " + TABLE_SONGS +
				" INNER JOIN " + TABLE_ALBUMS + " ON " + 
				TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
				" INNER JOIN " + TABLE_ARTIST + " ON " + 
				TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTIST + "." + COLUMN_ARTIST_ID+
				" WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " =\"";
		
		public static final String QUERY_ARTIST_FOR_SONG_SORT = 
				" ORDER BY " + TABLE_ARTIST + "." + COLUMN_ARTIST_NAME + "," +
		TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE " ;
		
//		CREATE VIEW IF NOT EXISTS artist_list AS SELECT artist.name, albums.name AS album,
//		songs.track, songs.title FROM songs INNER JOIN albums ON songs.album = albums._id
//		INNER JOIN artists ON albums.artist = artists._id ORDER BY 
//		artists.name, albums.name, songs.track
		
		public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
		public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " + 
		TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTIST + "." + COLUMN_ARTIST_NAME + 
		", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
		TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + 
		" FROM " + TABLE_SONGS + " INNER JOIN "+ TABLE_ALBUMS + " ON " + TABLE_SONGS + 
		"." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
		" INNER JOIN " + TABLE_ARTIST + " ON " + TABLE_ALBUMS + "." + 
		COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTIST + "." + COLUMN_ARTIST_ID +
		" ORDER BY " + TABLE_ARTIST + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS +
		"." + COLUMN_ALBUM_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK;
		
		public static final String QUERY_VIEW_SONG_INFO =  "SELECT " + COLUMN_ARTIST_NAME + ", " +
	            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
	            " WHERE " + COLUMN_SONG_TITLE + " = \"";
		
		
		private Connection conn;
		
		public boolean open() {
			try {
				
				conn = DriverManager.getConnection(CONNECTION_STRING);
				return true;
				
			}catch(SQLException e) {
				System.out.println("Couldnt connect to database: " + e.getMessage());
				return false;
			}
		}
		public void close() {
		
			try {
				if(conn != null) {
					conn.close();
				}
				
			}catch(SQLException e) {
				System.out.println("Couldnt close connection" + e.getMessage());
				
			}
		}
		
		public List<Artist> queryArtists(int sortOrder){
			
			StringBuilder sb = new StringBuilder("SELECT * FROM ");
			sb.append(TABLE_ARTIST);
			if(sortOrder != ORDER_BY_NONE) {
				sb.append(" ORDER BY ");
				sb.append(COLUMN_ARTIST_NAME);
				sb.append(" COLLATE NOCASE ");
				if(sortOrder == ORDER_BY_DESC) {
					sb.append("DESC");
				}else {
					sb.append("ASC");
				}
			}
			
			try (Statement  statement = conn.createStatement(); 
				 ResultSet results = statement.executeQuery(sb.toString())){
				
				List<Artist> artists = new ArrayList<>();
				
				while(results.next()) {
					Artist artist = new Artist();
					artist.setId(results.getInt(INDEX_ARTIST_ID));
					artist.setName(results.getString(INDEX_ARTIST_NAME));
					artists.add(artist);
					
				}
				return artists;
				
			}catch(SQLException e) {
				System.out.println("Query failed" + e.getMessage());
				return null;
			}	
		}
		
		public List<String> queryAlbumsForArtist(String artistName, int sortOrder){
			//SELECT albums.name FROM albums INNER JOIN artists ON albums.artist = artists._id 
			//WHERE artists.name = "Carole King" ORDER BY albums.name COLLATE NOCASE ASC
		
			StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
			
			sb.append(artistName);
			sb.append("\"");
			
			if(sortOrder != ORDER_BY_NONE) {
				sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
				
				if(sortOrder == ORDER_BY_ASC) {
					sb.append("ASC");
				}else {
					sb.append("DESC");
				}
			}
			System.out.println("SQL statement = " + sb.toString());
			try (Statement  statement = conn.createStatement(); 
					 ResultSet results = statement.executeQuery(sb.toString())){
					
					List<String> albums = new ArrayList<>();
					
					while(results.next()) {
						albums.add(results.getString(1));
						
					}
					return albums;
					
				}catch(SQLException e) {
					System.out.println("Query failed" + e.getMessage());
					return null;
				}	
		}
		
		public List<SongArtist> queryArtistsForSong(String songName,int sortOrder){
			StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
			sb.append(songName);
			sb.append("\"");
			if(sortOrder != ORDER_BY_NONE) {
				sb.append(QUERY_ARTIST_FOR_SONG_SORT);
				if(sortOrder == ORDER_BY_DESC) {
					sb.append("DESC");
				}else {
					sb.append("ASC");
					
				}
			}
			
			System.out.println("SQL Statement : " + sb.toString());
			
			try(Statement statement = conn.createStatement();
				ResultSet results = statement.executeQuery(sb.toString())){
					
				List<SongArtist> songArtists = new ArrayList<>();
				
				while(results.next()) {
					SongArtist songArtist = new SongArtist();
					songArtist.setArtistName(results.getString(1));
					songArtist.setAlbumName(results.getString(2));
					songArtist.setTrack(results.getInt(3));
					songArtists.add(songArtist);
					
				}
				return songArtists;
				
				}catch (SQLException e) {
					System.out.println("Query failed " + e.getMessage());
					return null;
				}
		}
		
		public void querySongsMetadata() {
			String sql = "SELECT * FROM " + TABLE_SONGS;
			try(Statement statement = conn.createStatement();
					ResultSet results = statement.executeQuery(sql)){
				
				ResultSetMetaData meta = results.getMetaData();
				int numColumns = meta.getColumnCount();
				for(int i = 1; i<= numColumns; i++) {
					System.out.format("Column %d in the songs table is name %s\n",
					i,meta.getColumnName(i));
				}
			}catch (SQLException e) {
				System.out.println("Query Failed " + e.getMessage());
			}
		}
		
		public int getCount(String table) {
			String sql ="SELECT COUNT(*) AS count, MIN(_id) FROM " + table;
			try(Statement statement = conn.createStatement();
				ResultSet results = statement.executeQuery(sql)){
				int count = results.getInt("count");
			
				return count;
			}catch(SQLException e) {
				System.out.println("Query Failed " + e.getMessage());
				return -1;
			}
		}
		public boolean createViewForSongArtists() {
			try(Statement statement = conn.createStatement()){
					statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
					return true;
				
				}catch(SQLException e) {
					System.out.println("Query Failed " + e.getMessage());
					return false;
				}
		}
		
		public List<SongArtist> querySongInfoView(String title) {
	        StringBuilder sb = new StringBuilder(QUERY_VIEW_SONG_INFO);
	        sb.append(title);
	        sb.append("\"");

	       System.out.println(sb.toString());

	       try (Statement statement = conn.createStatement();
	            ResultSet results = statement.executeQuery(sb.toString())) {

	           List<SongArtist> songArtists = new ArrayList<>();
	           while(results.next()) {
	               SongArtist songArtist = new SongArtist();
	               songArtist.setArtistName(results.getString(1));
	               songArtist.setAlbumName(results.getString(2));
	               songArtist.setTrack(results.getInt(3));
	               songArtists.add(songArtist);
	           }

	           return songArtists;

	       } catch(SQLException e) {
	           System.out.println("Query failed: " + e.getMessage());
	           return null;
	       }
	   }
		
	}















