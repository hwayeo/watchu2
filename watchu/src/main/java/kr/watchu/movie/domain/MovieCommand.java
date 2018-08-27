package kr.watchu.movie.domain;

import java.io.IOException;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class MovieCommand {
	private Integer movie_num;
	private String title;
	private String country;
	private Date released;
	private String director;
	private String actors;
	private String summary;
	private MultipartFile uploadPoster;
	private byte[] poster_img;
	private MultipartFile uploadBanner;
	private byte[] banner_img;
	private String genre;
	private String trailer;
	private float rate;
	private Integer rated_cnt;
	
	
	public Integer getMovie_num() {
		return movie_num;
	}
	public void setMovie_num(Integer movie_num) {
		this.movie_num = movie_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getReleased() {
		return released;
	}
	public void setReleased(Date released) {
		this.released = released;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public MultipartFile getUploadPoster() {
		return uploadPoster;
	}
	public void setUploadPoster(MultipartFile uploadPoster) throws IOException{
		this.uploadPoster = uploadPoster;
		setPoster_img(uploadPoster.getBytes());
	}
	public byte[] getPoster_img() {
		return poster_img;
	}
	public void setPoster_img(byte[] poster_img) {
		this.poster_img = poster_img;
	}
	public MultipartFile getUploadBanner() {
		return uploadBanner;
	}
	public void setUploadBanner(MultipartFile uploadBanner) throws IOException {
		this.uploadBanner = uploadBanner;
		setBanner_img(uploadBanner.getBytes());
	}
	public byte[] getBanner_img() {
		return banner_img;
	}
	public void setBanner_img(byte[] banner_img) {
		this.banner_img = banner_img;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public Integer getRated_cnt() {
		return rated_cnt;
	}
	public void setRated_cnt(Integer rated_cnt) {
		this.rated_cnt = rated_cnt;
	}
}
