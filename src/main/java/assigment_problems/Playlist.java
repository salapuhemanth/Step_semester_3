import java.util.Arrays;

/**
 * Problem 2: The Playlist
 * Category C - Assignment Problem 2
 *
 * Protects internal playlist array by returning a defensive copy to prevent external tampering.
 */
public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxCapacity) {
        this.songs = new String[maxCapacity];
        this.songCount = 0;
    }

    public void addSong(String songTitle) {
        if (songCount < songs.length) {
            songs[songCount++] = songTitle;
        }
    }

    public String[] getSongs() {
        // Return a defensive copy of the songs array
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("copy[0] = \"" + copy[0] + "\";");
        System.out.println("p.getSongs()[0] is still \"" + p.getSongs()[0] + "\"");
        System.out.println("p.getSongCount() -> " + p.getSongCount());
    }
}