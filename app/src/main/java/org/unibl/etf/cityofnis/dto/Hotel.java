package org.unibl.etf.cityofnis.dto;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
@Entity(tableName = "hotel")
public class Hotel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nameSr")
    private String nameSr="";

    @ColumnInfo(name = "descriptionSr")
    private String descriptionSr="";

    @ColumnInfo(name = "nameEn")
    private String nameEn="";

    @ColumnInfo(name = "descriptionEn")
    private String descriptionEn="";

    @ColumnInfo(name = "image")
    private String image="";

    @ColumnInfo(name = "latitude")
    private double latitude;
    @ColumnInfo(name = "longitude")
    private double longitude;

    @ColumnInfo(name = "favourite")
    private boolean favourite;

    public int getId() {
        return id;
    }

    public String getNameSr() {
        return nameSr;
    }

    public String getDescriptionSr() {
        return descriptionSr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public String getImage() {
        return image;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameSr(String nameSr) {
        this.nameSr = nameSr;
    }

    public void setDescriptionSr(String descriptionSr) {
        this.descriptionSr = descriptionSr;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public static ArrayList<Hotel> insertHotelData(){
        ArrayList<Hotel> hotelList = new ArrayList<>();

        Hotel hotel = new Hotel();
        hotel.setNameSr("Art Loft");
        hotel.setDescriptionSr("Art Loft je garni hotel smešten u mirnom kraju u samom centru grada. U sklopu ArtLoft-a nalazi se kafe bar i sala za doručak. Doručak je na bazi švedskog stola. Sve sobe su klimatizovane, zvučno izolovane, sa termoregulacijom, poseduju mini-barove, fenove za kosu, meni za odabir jastuka, sef.\n" +
                "\n" +
                "Dodatne usluge: wi-fi, room service 24/7, doručak na bazi švedskog stola, usluga pranja i peglanja veša.");
        hotel.setNameEn("Art Loft");
        hotel.setDescriptionEn("Art Loft is located in a quiet area in the city center. There is a coffee bar and a breakfast room within ArtLoft. Buffet breakfast includes the offer of this accommodation. All rooms are air-conditioned, soundproofed, with thermoregulation, mini-bars, hairdryers, safe.\n" +
                "\n" +
                "Services: wi-fi, room service 24/7, buffet breakfast, laundry and ironing services.");
        hotel.setImage("artloft");
        hotel.setLatitude(43.306851);
        hotel.setLongitude(21.887091);
        hotelList.add(hotel);



        hotel = new Hotel();
        hotel.setNameSr("Ideo Lux");
        hotel.setDescriptionSr("Hotel Ideo Lux je otvoren 2017. godine kao objekat viskoke kategorije. Nudi 18 soba i 2 aprtmana koji su opremljeni klima uređajem, wi-fi konekcijom, kablovskom televizijom, kao i sopstvenim kupatilom. Parking za goste hotela je besplatan.");
        hotel.setNameEn("Ideo Lux");
        hotel.setDescriptionEn("Ideo Lux Hotel opened in 2017 as a facility of high category. It offers 18 rooms and 2 apartments equipped with air conditioning, wi-fi, cable TV, and a private bathroom. Parking for hotel guests is free.");
        hotel.setImage("ideo");
        hotel.setLatitude(43.347034);
        hotel.setLongitude(21.873925);
        hotelList.add(hotel);


        hotel = new Hotel();
        hotel.setNameSr("Zen");
        hotel.setDescriptionSr("Garni hotel Zen nalazi se u mirnom delu grada. Poseduje  12 komfornih i luksuzno opremljenih soba, otvoreni bazen sa terasom na krovu, wellness & fitness centar, sala za konferencije kapaciteta do 60 osoba, lobi bar otvoren 24h.");
        hotel.setNameEn("Zen");
        hotel.setDescriptionEn("Garni hotel Zen is located in a quiet neighborhood. It offers 12 comfortable and luxurious rooms, an outdoor pool and terrace  on the roof, a wellness & fitness center, a conference room for up to 60 people, a lobby bar which is opened 24 hours.");
        hotel.setImage("zen");
        hotel.setLatitude(43.339254);
        hotel.setLongitude(21.923158);
        hotelList.add(hotel);


        hotel = new Hotel();
        hotel.setNameSr("Best Western Hotel My Place");
        hotel.setDescriptionSr( "Hotel se nalazi u samom centru grada, u mirnoj ulici na keju Nišave. Idealan je za poslovne ljude i organizovanje seminara. Hotel sadrži 30 moderno opremljenih soba sa mini barom, kablovskom televizijom, wireless internetom, sefom i đakuzi kadom.");
        hotel.setNameEn("Best Western Hotel My Place");
        hotel.setDescriptionEn("Directly in the center of the historic town, quietly situated next to the river and castle, the design hotel with 30 rooms of every comfort convinces even the most refined bussiness travallers and city tourists.");
        hotel.setImage("myplace");
        hotel.setLatitude(43.325148);
        hotel.setLongitude(21.90153);
        hotelList.add(hotel);

        hotel = new Hotel();
        hotel.setNameSr("Niški Cvet");
        hotel.setDescriptionSr( "Hotel se nalazi u samom centru grada, pored reke Nišave, sa pogledom na Tvrđavu i kej. Svi apartmani hotela Niški Cvet su opremljeni klimom i grejanjem sa individualnim podešavanjem, telefonom, satelitskom TV, LCD TV-om, wireless internetom 24h i bešumnim mini barom.");
        hotel.setNameEn("Niški Cvet");
        hotel.setDescriptionEn("The hotel is located in the center of the city, next to the river Nišava, overlooking Fortress and quay. All Niški Cvet apartments are equipped with air conditioning and heating with individual adjustment, telephone, satellite TV, LCD TV, wireless internet 24h and a silent mini bar.");
        hotel.setImage("niski_cvet");
        hotel.setLatitude(43.324178);
        hotel.setLongitude(21.898901);
        hotelList.add(hotel);


        hotel = new Hotel();
        hotel.setNameSr("Tami Residence");
        hotel.setDescriptionSr( "Tami Residence se nalazi na vidikovcu u mirnom delu grada, na samo 2 kilometara od centra. Hotel poseduje 70 luksuznih soba i apartmana, opemljenih LCD televizorima, internet konekcijom, mini barom, sefom. Gosti mogu da uživaju u tradicionalnim i internacionalnim jelima u restoranima ,,Sunset” i ,,Vip”.");
        hotel.setNameEn("Tami Residence");
        hotel.setDescriptionEn("Tami Residence is located in a quiet area of the city, just 2 kilometers from the center. The hotel has 70 luxurious rooms and suites, LCD televisions, internet connection, mini bar, safe. Guests can enjoy traditional and international dishes in the restaurants \"Sunset\" and \"Vip\".");
        hotel.setImage("tamiresidence");
        hotel.setLatitude(43.306851);
        hotel.setLongitude(21.887091);
        hotelList.add(hotel);

       /* hotel = new Hotel();
        hotel.setNameSr("New City Hotel");
        hotel.setDescriptionSr( "U strogom centru grada Niša, na pola minuta hoda od pešačke zone grada i dva minuta od niške Tvrđave nalazi se New City Hotel. Hotel je opremljen modernim sobama, restoranom, lobibarom, kao i konferencijskim salama.\n" +
                "\n" +
                "Dodatne usluge: sobe sa osobe sa invaliditetom,parking, wi-fi, 3 konferencijske sale, banket sala, room service, mogućnost transfera do aerodrome. (na zahtev).");
        hotel.setNameEn("New City Hotel");
        hotel.setDescriptionEn("About: In the heart of Nis, on the main crossroads of the city, just half a minute walk from the city pedestrian zone, and two minute walk from Nis Fortress, there is New City Hotel. Hotel offers modern rooms, restaurant, lobby bar, as well as, three multifunctional conference rooms.\n" +
                "\n" +
                "Services: rooms for people with disabilities,parking, wi-fi, three conference rooms, banquet room, room service, transfer to/from airport. (on request).");
        hotel.setImage("new_city_nis");
        hotel.setLatitude(43.320560);
        hotel.setLongitude(21.897830);
        hotelList.add(hotel);*/



        return hotelList;
    }


}



