import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FavouriteGenres {

	/*
	  {  
	 
		   "David": ["song1", "song2", "song3", "song4", "song8"],
		   "Emma":  ["song5", "song6", "song7"]
		},
		songGenres = {  
		   "Rock":    ["song1", "song3"],
		   "Dubstep": ["song7"],
		   "Techno":  ["song2", "song4"],
		   "Pop":     ["song5", "song6"],
		   "Jazz":    ["song8", "song9"]
		}

		Output: {  
		   "David": ["Rock", "Techno"],
		   "Emma":  ["Pop"]
		}
		
		*/
	public static Map<String,List<String>> fav(Map<String,List<String>> userSongs,Map<String,List<String>> songGenres){
		Map<String,List<String>> res=new HashMap<>();
		
		Set<String> users=userSongs.keySet();
		
		for(String s:users) {
			res.put(s, new ArrayList<>());
			
			Set<String> userSongSet=new HashSet<>(userSongs.get(s));
			
			
			Set<String> genres=songGenres.keySet();
			
			int max=0;
			
			for(String g:genres) {
				int fav=0;
				Set<String> genreSongs=new HashSet<>(songGenres.get(g));
				
				for(String song:genreSongs) {
					if(userSongSet.contains(song)) {
						fav++;
					}
				}
				if(fav==0) continue;
				if(fav>max) {
					max=fav;
					res.get(s).clear();
					res.get(s).add(g);
				}
				else if(fav==max) {
					res.get(s).add(g);
				}
				

			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,List<String>> userSongs =new HashMap<>();
		
		List<String> david=new ArrayList<>();
		david.add("song1");
		david.add("song2");

		david.add("song3");

		david.add("song4");

		david.add("song8");
		
		userSongs.put("David", david);
		
		List<String> emma=new ArrayList<>();
		emma.add("song5");
		emma.add("song6");

		emma.add("song7");
		
		userSongs.put("Emma", emma);
		
		Map<String,List<String>> songGenres =new HashMap<>();
		List<String> rock=new ArrayList<>();
		
		rock.add("song1");
		rock.add("song3");
		
		songGenres.put("Rock", rock);

		List<String> dubstep=new ArrayList<>();
		

		
		dubstep.add("song7");
		
		
		songGenres.put("Dubstep", dubstep);

		List<String> techno=new ArrayList<>();
		

		
		techno.add("song2");
		techno.add("song4");
		
		songGenres.put("Techno", techno);

		List<String> pop=new ArrayList<>();
		

		
		pop.add("song5");
		pop.add("song6");
		
		songGenres.put("Pop", pop);

		List<String> jazz=new ArrayList<>();
		
		

		
		jazz.add("song8");
		jazz.add("song9");
		
		songGenres.put("Jazz",jazz);
		
		fav(userSongs, songGenres);

	}

}
