package ra.spring_mvc_music_app.model.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;

@Entity
@Table(name = "Music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String musicName;
    private String singer;
    private String category;
    private String url;

    public Music() {
    }

    public Music(int id, String musicName, String singer, String category, String url) {
        this.id = id;
        this.musicName = musicName;
        this.singer = singer;
        this.category = category;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public void cloneMusic(Music s){
        this.id = s.getId();
        this.musicName = s.getMusicName();
        this.singer = s.getSinger();
        this.category = s.getCategory();
        this.url = s.getUrl();
    }
}
