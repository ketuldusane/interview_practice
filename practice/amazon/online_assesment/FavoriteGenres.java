package amazon.online_assesment;

import clone.shallow.P;

import java.util.*;

/**
 * Favorite Genres
 * <p>
 * Given a map Map<String, List<String>> userSongs with user names as keys and a list of all the songs that the user has
 * listened to as values.
 * <p>
 * Also given a map Map<String, List<String>> songGenres, with song genre as keys and a list of all the songs within
 * that genre as values. The song can only belong to only one genre.
 * <p>
 * The task is to return a map Map<String, List<String>>, where the key is a user name and the value is a list of the
 * user's favorite genre(s). Favorite genre is the most listened to genre. A user can have more than one favorite genre
 * if he/she has listened to the same number of songs per each of the genres.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * userSongs = {
 * "David": ["song1", "song2", "song3", "song4", "song8"],
 * "Emma":  ["song5", "song6", "song7"]
 * },
 * songGenres = {
 * "Rock":    ["song1", "song3"],
 * "Dubstep": ["song7"],
 * "Techno":  ["song2", "song4"],
 * "Pop":     ["song5", "song6"],
 * "Jazz":    ["song8", "song9"]
 * }
 * <p>
 * Output: {
 * "David": ["Rock", "Techno"],
 * "Emma":  ["Pop"]
 * }
 * <p>
 * Explanation:
 * David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
 * Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
 * Example 2:
 * <p>
 * Input:
 * userSongs = {
 * "David": ["song1", "song2"],
 * "Emma":  ["song3", "song4"]
 * },
 * songGenres = {}
 * <p>
 * Output: {
 * "David": [],
 * "Emma":  []
 * }
 */
public class FavoriteGenres {
  public static void main(String[] args) {
    HashMap<String, List<String>> userSongs = new HashMap<>();
    HashMap<String, List<String>> songGenres = new HashMap<>();

    userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
    userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

//    songGenres.put("Rock", Arrays.asList("song1", "song3"));
//    songGenres.put("Dubstep", Arrays.asList("song7"));
//    songGenres.put("Techno", Arrays.asList("song2", "song4"));
//    songGenres.put("Pop", Arrays.asList("song5", "song6"));
//    songGenres.put("Jazz", Arrays.asList("song8", "song9"));

    Map<String, List<String>> ans = new FavoriteGenres().favoriteGenres(userSongs, songGenres);
    for (String user : ans.keySet()) {
      System.out.println(user + " : " + ans.get(user));
    }
  }

  public Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
    if (userSongs == null || userSongs.isEmpty() || songGenres == null) {
      return new HashMap<>();
    }

    Map<String, String> songToGenre = new HashMap<>();
    songGenres.forEach((genre, songs) -> songs.forEach(song -> songToGenre.put(song, genre)));

    Map<String, List<String>> userFavorite = new HashMap<>();
    for (String user : userSongs.keySet()) {
      List<String> songs = userSongs.get(user);
      Map<String, Integer> userGenre = new HashMap<>();
      int max = 0;
      for (String song : songs) {
        String genre = songToGenre.get(song);
        userGenre.put(genre, userGenre.getOrDefault(genre, 0) + 1);
        max = Math.max(max, userGenre.get(genre));
      }

      List<String> genres = new ArrayList<>();
      for (String genre : userGenre.keySet()) {
        if (userGenre.get(genre) == max) {
          genres.add(genre);
        }
      }
      userFavorite.put(user, genres);
    }

    return userFavorite;
  }
}
