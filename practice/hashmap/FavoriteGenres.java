package hashmap;

import java.util.*;

/**
 * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has listened to as values.

   Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within that genre as values. The song can only belong to only one genre.

   The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre if he/she has listened to the same number of songs per each of the genres.

   Example 1:

   Input:
   userSongs = {
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

   Explanation:
   David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
   Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
   Example 2:

   Input:
   userSongs = {
   "David": ["song1", "song2"],
   "Emma":  ["song3", "song4"]
   },
   songGenres = {}

   Output: {
   "David": [],
   "Emma":  []
   }
 */

public class FavoriteGenres {
  public Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs,
                                                  Map<String, List<String>> songGenres) {
    if (songGenres == null || songGenres.isEmpty() || userSongs.isEmpty()) return new HashMap<>();

    HashMap<String, String> songToGenre  = new HashMap<>();
    songGenres.forEach((genre, songs) -> songs.forEach(song -> songToGenre.put(song, genre)));

    HashMap<String, List<String>> favoriteGenre = new HashMap<>();

    for (String user : userSongs.keySet()) {
      HashMap<String, Integer> count = new HashMap<>();
      int max = 0;

      List<String> songs = userSongs.get(user);
      for (String song : songs) {
        String genre = songToGenre.get(song);
        count.put(genre, count.getOrDefault(genre, 0) + 1);
        max = Math.max(max, count.get(genre));
      }

      List<String> genres = new ArrayList<>();
      for (String genre : count.keySet()) {
        if (count.get(genre) == max) {
          genres.add(genre);
        }
      }

      favoriteGenre.put(user, genres);
    }

    return favoriteGenre;
  }

  public static void main(String[] args) {
    HashMap<String, List<String>> userSongs = new HashMap<>();
    HashMap<String, List<String>> songGenres = new HashMap<>();

    userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
    userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

    songGenres.put("Rock", Arrays.asList("song1", "song3"));
    songGenres.put("Dubstep", Arrays.asList("song7"));
    songGenres.put("Techno", Arrays.asList("song2", "song4"));
    songGenres.put("Pop", Arrays.asList("song5", "song6"));
    songGenres.put("Jazz", Arrays.asList("song8", "song9"));

    new FavoriteGenres().favoriteGenres(userSongs, songGenres);
  }
}
