package dw.gameshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
@Entity
@Table(name = "Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "genre", nullable = false, length = 100)
    private String genre;
    @Column(name = "price")
    private int price;
    @Column(name = "image", length = 65535)
    private String image;
    @Column(name = "text", length = 65535)
    private String text;

    public Game() {
    }

    public Game(long id, String title, String genre, int price, String image, String text) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.image = image;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}