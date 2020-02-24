package ys.spring.aop.sqltimetest;

public class FilmEntity {

    private Integer id;
    private String filmName;
    private Integer filmTypeId;
    private FilmTypeEntity filmType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getFilmTypeId() {
        return filmTypeId;
    }

    public void setFilmTypeId(Integer filmTypeId) {
        this.filmTypeId = filmTypeId;
    }

    public FilmTypeEntity getFilmType() {
        return filmType;
    }

    public void setFilmType(FilmTypeEntity filmType) {
        this.filmType = filmType;
    }
}
