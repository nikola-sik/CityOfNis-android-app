package org.unibl.etf.cityofnis.dto;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "event")
public class Event {

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

    public static ArrayList<Event> insertEventData(){
        ArrayList<Event> eventList = new ArrayList<>();

        Event event = new Event();
        event.setNameSr("Nišville jazz festival");
        event.setDescriptionSr("OPŠTE INFORMACIJE O FESTIVALU:\n" +
                "Više od dvadeset godina, svakog leta niška Tvrđava postaje centar nastupa vrhunskih muzičara iz celog sveta. Od samog početka Nišvil je važio zajedinstven događaj koji je uspeo da spoji „tradicionalne” forme džeza sa etno zvucima.Popularni američki džez magazin “Downbeat” ocenio je Nišvil kao jedini festival koji promoviše muziku nastalu na američkom kontintentu,melodije Balkana i spoj ta dva pravca.\n" +
                "\n" +
                "Glavni program Nišvila održava se na dve bine unutar zidina tvrđave (Earth & Sky stage), na kojima se tokom festivala predstavi više od 20 poznatih muzičara iz celog sveta. Nastupi manje afirmisanih domaćih i stranih izvođača mogu se čuti na nekolikobina u gradukoje su besplatne za posetioce (River stage, Open stage, Movie stage, Youth stage, Midnight dance stage, Jam Session stage…).Prema procenama medija, glavni program prati oko 20000 posetilaca (5000 po večeri), dok prateće programe vidi i preko 120000 ljudi.Sve to dopunjuju brojne tribine, izložbe i posebno atraktivan defile muzičara kroz centralnu gradsku zonu.\n" +
                "O Nišvilu najviše govori lista muzičara koji su tokom proteklih godina nastupali: Solomon Burke, Billy Cobham, Benny Golson, Stanley Jordan, Candy Dulfer,Roy Hargrove, Sly and Robbie,Ginger Baker, Incognito,Tom Harrell, Iyeoka, De Phazz, Mungo Jerry Blues Band,The Original Blues Brothers,The Brand New Heavies, Kyle Eastwood,Nouvelle Vague i mnogi drugi. Fantastična atmosferai odličan program svakako su uticali na to daNišvilbude proglašen za jedan od najposećenijih džez festivala u jugoistočnoj Evropi.\n" +
                "\n" +
                "Zahvaljujući Nišvilu, Niš svakog avgusta živi uz muziku i postaje velika muzička pozornica.");
        event.setNameEn("Nišville Jazz Festival");
        event.setDescriptionEn("GENERAL INFORMATION ON THE FESTIVAL:\n" +
                "Each summer for over twenty years, the Niš Fortress becomes a center where top musicians from the whole world perform. Since the very beginning, Nišville has been a unique event that managed to combine “traditional” forms of jazz with ethno sounds. Popular American jazz magazine “Downbeat” reviewed Nišville as the only festival that promotes music from the American continent, Balkan melodies and the combination of these two.\n" +
                "The main program of Nišville takes place on two stages inside the Fortress (Earth& Sky stage), where over 20 renowned musicians from the entire world present themselves. Performances of less affirmed Serbian and foreign musicians can be heard at several location in the city which are free (River stage, Open stage, Movie stage, Youth stage, Midnight dance stage, Jam Session stage…). According to estimations of the media, the main program is attended by 20.000 visitors (5.000 each night), while the accompanying program is seen by over 120.000 people. All this is complemented by numerous forum discussions, exhibitions and an especially attractive parade of musicians through the city center.\n" +
                "The best acknowledgement of Nišville is the list of musicians who performed during the past years: Solomon Burke, Billy Cobham, Benny Golson, Stanley Jordan, Candy Dulfer, Roy Hargrove, Sly and Robbie, Ginger Baker, Incognito,Tom Harrell, Iyeoka, De Phazz, Mungo Jerry Blues Band, The Original Blues Brothers, The Brand New Heavies, Kyle Eastwood, Nouvelle Vague and many others. A fantastic atmosphere and an excellent program have certainly been the reason why Nišville was named one of the most visited jazz festivals in Southeast Europe.\n" +
                "Thanks to Nišville, Niš lives with music and becomes a large music stage each August.");
        event.setImage("nisville");
        event.setLatitude(43.3266506);
        event.setLongitude(21.8944009);
        eventList.add(event);



        event = new Event();
        event.setNameSr("Filmski susreti");
        event.setDescriptionSr("OPŠTE INFORMACIJE O FESTIVALU:\n" +
                "Svakog avgusta, počev od 1966. godine, gradonačelnik simbolično predaje ključeve grada glumcima i Niš postaje „grad glumaca i filma“. U kamenom amfiteatru Tvrđave, bioskopu pod otvorenim nebom, sedam dana posvećeno jeprikazivanju najboljih ostvarenja srpske kinematografije.  „Filmski susreti“ jedini je festival u Srbiji koji veliča i odaje priznanje filmskim glumcima. Tokom godina na festivalu su pored domaćih, gostovali i brojni inostrani glumci, uglavnom iz tadašnjih socijalističkih zemalja. Najpoznatiji glumački par, o čijem gostovanju se i danas priča, svakako su bili Elizabet Tejlor i Ričard Barton (uloga Tita u filmu „Sutjeska“) 1971. godine.");
        event.setNameEn("Film Festival");
        event.setDescriptionEn("GENERAL INFORMATION ON THE FESTIVAL:\n" +
                "Each August since 1966, the mayor symbolically has given the key of the city to actors and Niš has become “the city of actors and the film”. In a stone amphitheater in the Fortress, an outdoor cinema, seven days are dedicated to showing best works of Serbian cinematography. The Film Festival in Niš is the only festival in Serbia that pays tribute to film actorsand glorifies them. Over the years, many foreign actors, mostly from the then socialist countries, wereguests at the festival. Certainly the most famous couple, whose visit is still retold, is Elizabeth Taylor and Richard Burton (he played Tito in “Sutjeska”) in 1971.");
        event.setImage("filmski");
        event.setLatitude(43.324011);
        event.setLongitude(21.89632);
        eventList.add(event);


        event = new Event();
        event.setNameSr("Internacionalne horske svečanosti");
        event.setDescriptionSr("OPŠTE INFORMACIJE O FESTIVALU:\n" +
                "Festival amaterskog, horskog pevanja, osnovan je 1966. godine pod nazivom Jugoslovenske horske svecanosti. Održava se svake druge godine, početkom jula, u akustičnom prostoru amfiteatra u niškoj Tvrđavi. Program festivala obuhvata nastupe amaterskih horova iz celog sveta, kao i prateće događaje poput tematskih tribina,horskih ateljea, izložbi i sl. Pravi je užitak slušati zaljubljenike u horsku muziku, kojima pevanje predstavlja način relaksiranja i izražavanja ljubavi prema muzici. Tokom proteklih godina na Horskim svečanostima nastupilo je vise od 500 horova iz zemlje i inostranstva, 320 dirigenata,27 orkestara, sa vise od 42000 ucesnika i 120 solista. Događaj se održava u avgustu.");
        event.setNameEn("International Choir Festival");
        event.setDescriptionEn("GENERAL INFORMATION ON THE FESTIVAL:\n" +
                "The Festival of amateur choral singing was founded in 1966 under the title Yugoslavian Choral Festival. It takes place every two years at the beginning of July in the acoustic space of the amphitheater in the Fortress. The program of the festival includes performances of amateur choirs from the entire world, as well as accompanying events such as thematic discussions, choir studios, exhibitions etc. It is a real pleasure to listen choir music enthusiasts, to whom singing is a wayto relax and to express their love of music. During the previous years, more than 500 choirs from Serbia and abroad, 320 conductors, 27 orchestras and more than 42.000 choristers and 120 soloists participated at the Choir Festival. The event is held in August.");
        event.setImage("horske");
        event.setLatitude(43.324011);
        event.setLongitude(21.89639);
        eventList.add(event);

        event = new Event();
        event.setNameSr("Niške muzičke svečanosti");
        event.setDescriptionSr("Niške muzičke svečanosti okupljaju ljubitelje klasične muzike i izvođače iz svih delova sveta. Događaj se održava u okobru i novembru.");
        event.setNameEn("Nis music festival");
        event.setDescriptionEn("Nis music festivals gather fans of classical music and performers from all parts of the world. The event is held in october and november");
        event.setImage("orkestar");
        event.setLatitude(43.3208809);
        event.setLongitude(21.8934882);
        eventList.add(event);

        return eventList;
    }



}
