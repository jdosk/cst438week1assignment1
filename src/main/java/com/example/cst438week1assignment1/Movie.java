package com.example.cst438week1assignment1;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {

  @Id
  @GeneratedValue
  private long id;

  @NotNull
  @Size(min=1, max=35)
  private String title;

  @NotNull
  @Size(min=1, max=25)
  private String name;

  @NotNull
  @Size(min=1, max=1)
  private String rating;

  private String date;

  public Movie() {

  }

  public Movie(long id, String title, String name, String rating, String date) {
    this.id = id;
    this.title = title;
    this.name = name;
    this.rating = rating;
    this.date = date;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getName() {
    return name;
  }

  public String getRating() {
    return rating;
  }

  public String getDate() {
    return date;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
