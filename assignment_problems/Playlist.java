// Week 7 Assignment - Problem 2: The Playlist
// Demonstrates defensive copying: getSongs() returns a copy, not the original array

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.songCount = 0;
    }

    public void addSong(String title) {
        if (songCount < songs.length) {
            songs[songCount] = title;
            songCount++;
        } else {
            System.out.println("Playlist is full. Cannot add: " + title);
        }
    }

    // Returns a COPY of the array — external modifications don't affect the playlist
    public String[] getSongs() {
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
        copy[0] = "Hacked"; // modifying the copy

        // Playlist's real content is unchanged
        System.out.println("Playlist song 1: " + p.getSongs()[0]); // Expected: Song A
        System.out.println("Song count: " + p.getSongCount());       // Expected: 2
    }
}
