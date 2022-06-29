
public class main {

	
	public static void main (String[] args) {
		
		League<Team<FootballPlayer>> footballLeague = new League("AFL");
		Team<FootballPlayer> fenerbahce = new Team<>("Fenerbahce");
		Team<FootballPlayer> galatasaray = new Team<>("Galatasaray");
		Team<FootballPlayer> barcelona = new Team<>("Barcelona");
		Team<FootballPlayer> realmadrid = new Team<>("Realmadrid");
		
		Team<BasketballPlayer> fener = new Team<>("Fenerbahce");
		
		fenerbahce.matchResult(galatasaray, 6, 0);
		fenerbahce.matchResult(realmadrid, 0, 2);
		barcelona.matchResult(realmadrid, 0, 0);
	
		footballLeague.add(fenerbahce);
		footballLeague.add(galatasaray);
		footballLeague.add(barcelona);
		footballLeague.add(realmadrid);
		
		footballLeague.showLeagueTable();
		
	}
}
