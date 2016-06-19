/**
 * Created by Dillon on 4/11/2016.
 */
public class Record {
    private String title;
    private String artist;
    private int recordID;
    private int year;


    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getYear() {
        return year;
    }


    public Record(String albumTitle, String albumArtist, int albumYear, int ID){
        title = albumTitle;
        artist = albumArtist;
        year = albumYear;
        recordID = ID;
    }

    public String toString() {
        return (this.getTitle() + " by " + this.getArtist() + ", " + this.getYear() +"\n");
    }

    static class LP extends Record {
        private int rotationsPerMinute;
        public LP(String albumTitle, String albumArtist, int albumYear, int ID){
            super(albumTitle, albumArtist, albumYear, ID);
            rotationsPerMinute = 33;
        }
    }

    static class EP extends Record {
        private int rotationsPerMinute;
        public EP(String albumTitle, String albumArtist, int albumYear, int ID){
            super(albumTitle, albumArtist, albumYear, ID);
            rotationsPerMinute = 45;
        }
    }
}
